package com.badlogic.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.game.screen.*;

public class Game extends ApplicationAdapter {

	Viewport viewport;
	OrthographicCamera camera;

	// graphics
	// TODO - move to LaneManager class as a screen
	SpriteBatch batch;
	BitmapFont font;

	// music
	// TODO - move to LaneManager class
	SongManager songManager;
	Music music;

	// handle notes
	LaneManager laneManager;
	NoteReader noteReader;

	// game state and file names
	String state = "menu"; // keeps track of game navigation
	String chartFileName = "";

	// screens
	MenuScreen menuScreen;
	HelpScreen helpScreen;
	SongSelectScreen songSelectScreen;
	ResultsScreen resultsScreen;

	@Override
	public void create () {

		// window size
		Gdx.graphics.setWindowedMode(800, 800);
		Gdx.graphics.setResizable(false);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true);
		viewport = new FitViewport(800, 800, camera);

		// graphics
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/courier.fnt"), Gdx.files.internal("data/courier_0.png"), true);
		font.setColor(Color.WHITE);

		// menu music
		music = Gdx.audio.newMusic(Gdx.files.internal("audio/sdvxv.mp3"));

		menuScreen = new MenuScreen();
		helpScreen = new HelpScreen();
		songSelectScreen = new SongSelectScreen();
		resultsScreen = new ResultsScreen();

	}

	@Override
	public void render () {

		camera.update();

		// clear screen
		Gdx.gl.glClearColor(.05f, .05f, .05f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// menu screen
		if (state.equals("menu")) {
			batch.begin();
			state = menuScreen.updateString();
			menuScreen.draw(batch);
			music.setVolume(.5f);
			music.play();
			batch.end();
		}

		else if (state.equals("help")) {
			batch.begin();
			state = helpScreen.updateString();
			helpScreen.draw(batch);
			batch.end();
		}

		// song select screen
		else if (state.equals("select")) {
			batch.begin();
			music.setLooping(true);
			state = songSelectScreen.updateString();
			songSelectScreen.draw(batch);
			chartFileName = songSelectScreen.chartFileName;
			batch.end();
		}

		// results screen
		else if (state.equals("results")) {
			batch.begin();
			music.setLooping(true);
			state = resultsScreen.updateString();
			resultsScreen.draw(batch);
			batch.end();
		}

		// uploads notes into laneManager and sets state to play
		// TODO - move note loading to NoteReader class
		else if (state.equals("upload")) {
			// read in notes from txt file, parse and add to each lane
			noteReader = new NoteReader("charts/" + chartFileName + ".txt");

			// music and time management
			songManager = new SongManager(noteReader.bpm, noteReader.offset);
			music.stop();
			music.setVolume(1);
			music = Gdx.audio.newMusic(Gdx.files.internal("audio/" + noteReader.songFileName));

			// add in lanes and notes
			laneManager = new LaneManager(songManager);
			laneManager.box.x = 96;
			laneManager.noteSpeed = songSelectScreen.noteSpeed + 750; // 750 is an added amount so notes are not too slow

			// set positions of lanes one pixel apart from each other
			for (int i = 0; i < laneManager.lanes.length; i++) {
				laneManager.lanes[i].box.x = laneManager.lanes[i].sprite.getWidth() * laneManager.lanes[i].sprite.getScaleX() * i + laneManager.box.x + laneManager.lanes[i].sprite.getScaleX() * i;
			}

			// calculate score vaules for notes
			noteReader.putNotesIntoLaneManager(laneManager);
			laneManager.setNoteValue();
			laneManager.findLengthOfSongInSeconds();
			state = "play";
		}

		// plays song
		// TODO - make PlayScreen class
		else if (state.equals("play")) {
			songManager.update(); // updates position of song
			laneManager.update(); // updates positions of notes, scoring

			// play song once
			if (songManager.songPosition > 0 && songManager.songPosition < 1 && !music.isPlaying()) {
				music.play();
				music.setLooping(false);
				music.setPosition(0);
			}

			// change screen three seconds after final note hit
			// exit song if player presses escape
			if (songManager.songPosition > laneManager.lengthOfSongInSeconds + 3 ||
			    Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
				// set up results screen before changing state
				resultsScreen.score = laneManager.score;
				resultsScreen.scores = laneManager.scores;
				resultsScreen.maxNoteCount = laneManager.maxNoteCount;
				resultsScreen.songTitle = noteReader.songTitle;
				resultsScreen.difficulty = noteReader.difficulty;
				resultsScreen.lifeGauge = laneManager.lifeGauge;
				resultsScreen.calculateGrade();
				// reset values if escaped
				if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
					resultsScreen.lifeGauge = 0;
				}
				// change music back to menu music, looping
				music.stop();
				music.setLooping(true);
				music = Gdx.audio.newMusic(Gdx.files.internal("audio/sdvxv.mp3"));
				music.setVolume(.5f);
				music.play();
				state = "results";
			}

			// draw score, judgement text, combo counter
			// TODO - move to LaneManager draw function
			batch.begin();
			font.getData().setScale(1);
			laneManager.draw(batch);
			font.getData().setScale(2);
			if (laneManager.noteCount > 2)
				font.draw(batch, laneManager.noteCount + "", 202, 460);
			String score = String.valueOf((int) laneManager.score);
			while (score.length() < 6) {
				score = "0" + score;
			}
			font.draw(batch, score, 470, 44);
			// draw song information
			// TODO - make Song class for song information
			font.getData().setScale(1);
			font.draw(batch, noteReader.songTitle.substring(0, Math.min(13, noteReader.songTitle.length())), 456, 498);
			font.draw(batch, noteReader.artist.substring(0, Math.min(13, noteReader.artist.length())), 456, 555);
			font.draw(batch, "BPM " + (int) songManager.bpm, 456, 610);
			font.draw(batch, "Difficulty " + noteReader.difficulty, 456, 665);
			batch.end();
		}

		batch.setProjectionMatrix(camera.combined);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}

}

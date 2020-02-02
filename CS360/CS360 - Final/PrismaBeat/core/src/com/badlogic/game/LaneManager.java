/**
 * This keeps track of all Lanes, Notes, and scoring information
 * It needs references to the SongManager and other Lanes so it can
 * draw notes at the correct positions and keep track of all timings
 */
package com.badlogic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class LaneManager {

    SongManager songManager;
    Lane[] lanes = new Lane[4];

    // timing
    int noteSpeed;
    float lengthOfSongInSeconds = 0;

    // scoring
    int noteCount;
    int maxNoteCount;
    public Array<String> scores;
    Array<Float> hitTimes;
    final int MAX_SCORE = 999999;
    public float score;
    float noteValue;
    float lifeGauge;
    float noteLifeValue;

    // judgement times
    static final int VIVID = 30;
    static final int CLEAR = 60;
    static final int HAZY = 90;
    static final int DULL = 100;

    // graphical
    ShapeRenderer shapeRenderer;
    Rectangle box;
    Sprite laneContainer;
    Sprite albumCover;

    // ui sprites
    static Sprite vivid = new Sprite(new Texture(Gdx.files.internal("graphics/ui/labels/vivid_classic_gs.png")));
    static Sprite clear = new Sprite(new Texture(Gdx.files.internal("graphics/ui/labels/clear_classic_gs.png")));
    static Sprite hazy = new Sprite(new Texture(Gdx.files.internal("graphics/ui/labels/hazy_classic_gs.png")));
    static Sprite dull = new Sprite(new Texture(Gdx.files.internal("graphics/ui/labels/dull_classic_gs.png")));
    static Sprite leftWarning = new Sprite(new Texture(Gdx.files.internal("graphics/ui/layout/warningleft_classic_gs.png")));
    static Sprite rightWarning = new Sprite(new Texture(Gdx.files.internal("graphics/ui/layout/warningright_classic_gs.png")));

    public LaneManager(SongManager songManager) {

        this.songManager = songManager;

        noteSpeed = 1000; // how fast notes come down

        box = new Rectangle(0, 0, 0, 0);

        // set up lanes with controls
        lanes[0] = new Lane(this, Input.Keys.W, new int [] { Input.Keys.Q, Input.Keys.C });
        lanes[1] = new Lane(this, Input.Keys.E, new int [] { Input.Keys.Q, Input.Keys.C });
        lanes[2] = new Lane(this, Input.Keys.I, new int [] { Input.Keys.P, Input.Keys.M });
        lanes[3] = new Lane(this, Input.Keys.O, new int [] { Input.Keys.P, Input.Keys.M });

        noteCount = 0;
        scores = new Array<String>();
        hitTimes = new Array<Float>();
        noteValue = 0;
        lifeGauge = 0;

        // position art and ui sprites
        laneContainer = new Sprite(new Texture("graphics/ui/layout/allelements_classic_gs.png"));
        laneContainer.flip(false, true);
        albumCover = new Sprite(new Texture("graphics/album_covers/nekkoya.png"));
        albumCover.flip(false, true);
        albumCover.setSize(244, 244);

        // position and flip judgmenet text lables
        vivid.setFlip(false, true);
        vivid.setPosition(180, 400);
        clear.setFlip(false, true);
        clear.setPosition(180, 400);
        hazy.setFlip(false, true);
        hazy.setPosition(180, 400);
        dull.setFlip(false, true);
        dull.setPosition(180, 400);

        // TODO - add color switch warning sign implementation
        leftWarning.setFlip(false, true);
        rightWarning.setFlip(false, true);

        shapeRenderer = new ShapeRenderer();

    }

    // calculates point value of each note in propotion to how many notes there are
    // each note is worth MAX_VALUE / numberOfNotes
    public void setNoteValue() {
        int noteTotal = 0;
        for (int i = 0; i < lanes.length; i++) {
            noteTotal += lanes[i].notes.size;
        }
        noteValue = (float)MAX_SCORE / noteTotal;
        noteLifeValue = 100f / noteTotal * 2.5f;
    }


    public void update() {

        // keep track of max combo
        maxNoteCount = noteCount > maxNoteCount ? noteCount : maxNoteCount;

        // update lanes
        for (int i = 0; i < lanes.length; i++) {
            lanes[i].update();
        }

    }

    // LibGDX does not have a function to return the length of Music
    // this returns the time at which the last note is found
    public void findLengthOfSongInSeconds() {
        float lastBeat = 0;
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].notes.get(lanes[i].notes.size - 1).beat > lastBeat) {
                lastBeat = lanes[i].notes.get(lanes[i].notes.size - 1).beat;
            }
        }
        lengthOfSongInSeconds = lastBeat * songManager.secondsPerBeat;
    }

    // handle scoring and life gauge
    public void insertScore(String status) {

        // adds to score and lifeGauge
        if (status.equals("VIVID")) {
            score += noteValue;
            lifeGauge += noteLifeValue;
        }
        else if (status.equals("CLEAR")) {
            score += noteValue * .75f;
            lifeGauge += noteLifeValue * .75f;
        }
        else if (status.equals("HAZY")) {
            score += noteValue * .5f;
            lifeGauge += noteLifeValue * .5f;
        }
        else if (status.equals("DULL")) {
            lifeGauge -= 2.5f; //noteLifeValue * 10;
        }

        if (lifeGauge < 0) {
            lifeGauge = 0;
        }
        else if (lifeGauge > 100) {
            lifeGauge = 100;
        }

    }

    public void draw(SpriteBatch batch) {

        batch.end();

        // draws colored background and rectangles behind lanes
        // positions are hard-coded
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < lanes.length; i++) {
            Color faintColor = new Color(lanes[i].currentColor);
            float[] faintColorHSV = new float[3];
            faintColor.toHsv(faintColorHSV);
            faintColorHSV[2] = .14f;
            faintColor.fromHsv(faintColorHSV);
            faintColor.set(faintColor);
            shapeRenderer.setColor(faintColor);
            if (i == 0) {
                shapeRenderer.rect(0,0, 94, 800);
            }
            else if (i == 2) {
                shapeRenderer.rect(96 + 68 * 4,0, 600, 800);
            }
            faintColorHSV[2] = .1f;
            if (lanes[i].pressed) {
                faintColorHSV[2] = .18f;
            }
            faintColor.fromHsv(faintColorHSV);
            faintColor.set(faintColor);
            shapeRenderer.setColor(faintColor);
            shapeRenderer.rect(96 + 68 * i, 80, 64, 800);
        }
        shapeRenderer.end();

        // draws all notes
        batch.begin();
        for (int i = 0; i < lanes.length; i++) {
            lanes[i].draw(batch);
        }

        albumCover.setPosition(448, 224);
        albumCover.draw(batch);
        batch.end();

        // background colors
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(lanes[0].color);
        shapeRenderer.rect(436, 628, 268 * (lifeGauge / 100f), 40);
        shapeRenderer.rect(436 + 12, 72, 248 * Math.min(Math.max(0, (songManager.songPosition / lengthOfSongInSeconds)), 1), 20);
        shapeRenderer.setColor(lanes[0].currentColor);
        shapeRenderer.rect(96, 0, 132, 64);
        shapeRenderer.setColor(lanes[2].currentColor);
        shapeRenderer.rect(96+136, 0, 132, 64);
        shapeRenderer.end();

        batch.begin();

        laneContainer.draw(batch); // entire ui

        // draw sprite for judgement
        if (scores.size > 0) {
            if (scores.get(scores.size - 1).equals("VIVID")) {
                vivid.draw(batch);
            }
            else if (scores.get(scores.size - 1).equals("CLEAR")) {
                clear.draw(batch);
            }
            else if (scores.get(scores.size - 1).equals("HAZY")) {
                hazy.draw(batch);
            }
            else if (scores.get(scores.size - 1).equals("DULL")) {
                dull.draw(batch);
            }
        }

    }

}

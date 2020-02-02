package com.badlogic.game.screen;

import com.badlogic.game.SongManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SongSelectScreen {

    // song selection information
    public String[] chartFileNames = { "nekkoya_e", "nekkoya_n", "nekkoya_h", "banana_allergy_monkey_e", "banana_allergy_monkey_h", "picky_picky_h", "now_or_never!_h", "crepe_suzette_h", "1116_h", "if_h", "very_nice_h" };
    public String[] songTitles = { "3-Nekkoya", "6-Nekkoya", "9-Nekkoya", "3-BananaAllergyMonkey", "7-BananaAllergyMonkey", "8-Picky Picky", "7-Now or Never!", "10-Crepe Suzette", "10-1116", "10-If", "8-Very Nice" };
    public String chartFileName; // file loaded into NoteReader
    int index; // current option player has selected
    public int noteSpeed; // how fast the notes come down

    // graphics
    BitmapFont font;
    String[] hexCodes = { "420000", "422e00", "264200", "004212", "003242", "0b0042", "000260", "42003f", "420017" };
    public Color color;
    int colorIndex;
    int prevFrameCount;
    int frameCount;
    SongManager timer;

    ShapeRenderer shapeRenderer;

    public SongSelectScreen() {

        index = 0;
        noteSpeed = 250;

        font = new BitmapFont(Gdx.files.internal("data/courier.fnt"), Gdx.files.internal("data/courier_0.png"), true);
        font.setColor(Color.WHITE);

        color = Color.valueOf(hexCodes[0]);
        prevFrameCount = 0;
        frameCount = 0;

        timer = new SongManager(140, 500l);

        shapeRenderer = new ShapeRenderer();

    }

    public String updateString() {

        // change background color
        timer.update();
        frameCount = (int)timer.songPositionInBeats;
        if (frameCount != prevFrameCount) {
            prevFrameCount = frameCount;
            colorIndex += 1;
            color = Color.valueOf(hexCodes[colorIndex % hexCodes.length]);
        }

        // user changes note speed
        if (Gdx.input.isKeyJustPressed(Input.Keys.E) && noteSpeed > 25) {
            noteSpeed -= 25;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            noteSpeed += 25;
        }

        // menu navigation
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            return "menu";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            index = Math.floorMod(index + 1, chartFileNames.length);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            index = Math.floorMod(index - 1, chartFileNames.length);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P) || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            chartFileName = chartFileNames[index];
            return "upload";
        }

        return "select";

    }

    public void draw(SpriteBatch batch) {

        // draw background color
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(0, 0, 800, 800);
        shapeRenderer.end();
        batch.begin();
        // draw song names at specific positions
        font.getData().setScale(1.85f);
        font.draw(batch, "> " + songTitles[Math.floorMod(index, songTitles.length)] + " <", 20, 355 + 25);
        font.getData().setScale(1.5f);
        font.draw(batch, songTitles[Math.floorMod(index - 1, songTitles.length)], 200, 250 + 25);
        font.draw(batch, songTitles[Math.floorMod(index + 1, songTitles.length)], 200, 460 + 25);
        font.draw(batch, songTitles[Math.floorMod(index - 2, songTitles.length)], 250, 250 - 60 * 1 + 25);
        font.draw(batch, songTitles[Math.floorMod(index + 2, songTitles.length)], 250, 460 + 60 * 1 + 25);
        font.draw(batch, songTitles[Math.floorMod(index - 3, songTitles.length)], 300, 250 - 60 * 2 + 25);
        font.draw(batch, songTitles[Math.floorMod(index + 3, songTitles.length)], 300, 460 + 60 * 2 + 25);
        font.draw(batch, songTitles[Math.floorMod(index - 4, songTitles.length)], 350, 250 - 60 * 3 + 25);
        font.draw(batch, songTitles[Math.floorMod(index + 4, songTitles.length)], 350, 460 + 60 * 3 + 25);
        font.draw(batch, songTitles[Math.floorMod(index - 5, songTitles.length)], 400, 250 - 60 * 4 + 25);
        font.draw(batch, songTitles[Math.floorMod(index + 5, songTitles.length)], 400, 460 + 60 * 4 + 25);
        // draw song select help options
        font.getData().setScale(1);
        font.draw(batch, "Note speed: " + noteSpeed, 25, 25);
        font.draw(batch, "E> Decrease", 25, 55);
        font.draw(batch, "I> Increase", 25, 85);
        font.draw(batch, "Q> Back", 25, 653);
        font.draw(batch, "W> Up", 25, 685);
        font.draw(batch, "O> Down", 25, 715);
        font.draw(batch, "P> Play", 25, 745);

    }

}

package com.badlogic.game.screen;

import com.badlogic.game.SongManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class ResultsScreen {

    // information
    public String songTitle;
    public int difficulty;
    public float score;
    public Array<String> scores;
    public int maxNoteCount;
    public float lifeGauge;

    // note counts
    int vivid;
    int clear;
    int hazy;
    int dull;

    // grade rankings
    public static int S = 900000;
    public static int A = 850000;
    public static int B = 800000;
    public static int C = 750000;
    public static int D = 700000;

    // graphics
    BitmapFont font;
    static Texture textureS = new Texture(Gdx.files.internal("graphics/ui/grades/grade_s_classic_gs.png"));
    static Texture textureA = new Texture(Gdx.files.internal("graphics/ui/grades/grade_a_classic_gs.png"));
    static Texture textureB = new Texture(Gdx.files.internal("graphics/ui/grades/grade_b_classic_gs.png"));
    static Texture textureC = new Texture(Gdx.files.internal("graphics/ui/grades/grade_c_classic_gs.png"));
    static Texture textureD = new Texture(Gdx.files.internal("graphics/ui/grades/grade_d_classic_gs.png"));
    static Texture textureF = new Texture(Gdx.files.internal("graphics/ui/grades/grade_f_classic_gs.png"));
    Sprite grade;

    // background color changing variables
    // TODO - make background screen so this code is not duplicated in this class, MenuScreen, and SongSelectScreen
    String[] hexCodes = { "420000", "422e00", "264200", "004212", "003242", "0b0042", "000260", "42003f", "420017" };
    Color color;
    int colorIndex;
    int prevFrameCount;
    int frameCount;
    SongManager timer; // makes color change at 140 times per minute to match title song

    ShapeRenderer shapeRenderer;

    // animation timers
    public float percent;

    public ResultsScreen() {

        songTitle = "";
        difficulty = 0;
        percent = vivid = clear = hazy = dull = 0;

        font = new BitmapFont(Gdx.files.internal("data/courier.fnt"), Gdx.files.internal("data/courier_0.png"), true);
        font.setColor(Color.WHITE);
        font.getData().setScale(2);

        grade = new Sprite(textureS);

        color = Color.valueOf(hexCodes[0]);
        prevFrameCount = 0;
        frameCount = 0;

        timer = new SongManager(140, 500l);

        shapeRenderer = new ShapeRenderer();

    }

    public String updateString() {

        // score count up, move grade sprite
        percent = percent < 1 ? percent + .005f : 1;

        // change background color
        timer.update();
        frameCount = (int)timer.songPositionInBeats;
        if (frameCount != prevFrameCount) {
            prevFrameCount = frameCount;
            colorIndex += 1;
            color = Color.valueOf(hexCodes[colorIndex % hexCodes.length]);
        }

        // go back to song select screen when player finished
        // cannot escape for 3 seconds, aka && frameCount > 180
        if (Gdx.input.isKeyPressed(Input.Keys.P) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) || Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.isKeyJustPressed(Input.Keys.Q) && frameCount > 180) {
            return "select";
        }

        return "results";

    }

    // calculates grade and counts amount of notes hit
    public void calculateGrade() {

        percent = vivid = clear = hazy = dull = 0; // reset

        // change grade sprite
        if (score >= S) {
            grade.setTexture(textureS);
        }
        else if (score >= A) {
            grade.setTexture(textureA);
        }
        else if (score >= B) {
            grade.setTexture(textureB);
        }
        else if (score >= C) {
            grade.setTexture(textureC);
        }
        else if (score >= D) {
            grade.setTexture(textureD);
        }
        else {
            grade.setTexture(textureF);
        }

        grade.setFlip(false, true);

        // count note hits
        for (int i = 0; i < scores.size; i++) {
            if (scores.get(i).equals("VIVID")) {
                vivid += 1;
            }
            else if (scores.get(i).equals("CLEAR")) {
                clear += 1;
            }
            else if (scores.get(i).equals("HAZY")) {
                hazy += 1;
            }
            else {
                dull += 1;
            }
        }

    }

    public void draw(SpriteBatch batch) {

        // draw background color
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(0, 0, 800, 800);
        shapeRenderer.end();
        batch.begin();
        // draw song information
        font.getData().setScale(2);
        font.draw(batch, songTitle + " - " + difficulty, 70, 100);
        font.draw(batch, lifeGauge >= 70 ? "TRACK PASSED" : "TRACK FAILED", 70, 175);
        font.getData().setScale(3);
        font.draw(batch, "" + (int)(score * percent), 70, 275);
        font.getData().setScale(2);
        grade.setPosition(500 + (int)(275 - 275 * percent), 250);
        grade.draw(batch);
        font.draw(batch, "MAX COMBO - " + (int)(maxNoteCount * percent), 70, 600);
        font.draw(batch, "VIVID - " + (int)(vivid * percent), 70, 400);
        font.draw(batch, "CLEAR - " + (int)(clear * percent), 70, 450);
        font.draw(batch, "HAZY  - " + (int)(hazy * percent), 70, 500);
        font.draw(batch, "DULL  - " + (int)(dull * percent), 70, 550);
        font.getData().setScale(1);
        font.draw(batch, "P> Return to song select", 70, 675);

    }

}

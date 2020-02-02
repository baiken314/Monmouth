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

import static com.badlogic.gdx.Gdx.app;

public class MenuScreen {

    // graphics
    Sprite logo;
    boolean logoMovingUp;
    BitmapFont font;
    String[] hexCodes = { "420000", "422e00", "264200", "004212", "003242", "0b0042", "000260", "42003f", "420017" };
    public Color color;
    int colorIndex;
    int prevFrameCount;
    int frameCount;
    SongManager timer;

    ShapeRenderer shapeRenderer;

    public MenuScreen() {

        logo = new Sprite(new Texture(Gdx.files.internal("graphics/ui/labels/logo2big.png")));
        logo.setScale(2);
        logo.setFlip(false, true);
        logo.setPosition(Gdx.graphics.getWidth() / 2 - logo.getWidth() / 2, Gdx.graphics.getHeight() / 2 - logo.getHeight() * 1.5f);
        logoMovingUp = true;

        font = new BitmapFont(Gdx.files.internal("data/courier.fnt"), Gdx.files.internal("data/courier_0.png"), true);
        font.setColor(Color.WHITE);

        color = Color.valueOf(hexCodes[0]);
        prevFrameCount = 0;
        frameCount = 0;

        timer = new SongManager(140, 500l);

        shapeRenderer = new ShapeRenderer();

    }

    public String updateString() {

        // make logo move
        if (logoMovingUp) {
            logo.setY(logo.getY() - .15f);
            logoMovingUp = logo.getY() > 200;
        }
        else {
            logo.setY(logo.getY() + .15f);
            logoMovingUp = logo.getY() > 215;
        }

        // change background color
        timer.update();
        frameCount = (int)timer.songPositionInBeats;
        if (frameCount != prevFrameCount) {
            prevFrameCount = frameCount;
            colorIndex += 1;
            color = Color.valueOf(hexCodes[colorIndex % hexCodes.length]);
        }

        // player options
        if (Gdx.input.isKeyJustPressed(Input.Keys.P) || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            return "select";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            return "help";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            app.exit();
        }

        return "menu";

    }

    public void draw(SpriteBatch batch) {

        // draw background color
        // TODO - make static background chaning function
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(0, 0, 800, 800);
        shapeRenderer.end();
        batch.begin();
        // draw logo and options
        logo.draw(batch);
        font.getData().setScale(1.5f);
        font.draw(batch, "P> Play  W> Help  Q> Quit", 60, 550);

    }

}

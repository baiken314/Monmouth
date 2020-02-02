package com.badlogic.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelpScreen {

    public Sprite helpUI;
    BitmapFont font;

    public HelpScreen() {

        helpUI = new Sprite(new Texture(Gdx.files.internal("graphics/ui/layout/helpscreen_withbg_gs.png")));
        helpUI.setFlip(false, true);

        font = new BitmapFont(Gdx.files.internal("data/courier.fnt"), Gdx.files.internal("data/courier_0.png"), true);
        font.setColor(Color.WHITE);

    }

    public String updateString() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            return "menu";
        }

        return "help";
    }

    public void draw(SpriteBatch batch) {

        helpUI.draw(batch);
        font.draw(batch, "Q> Back", 25, 750);

    }

}

/**
 * This keeps track of Notes for one lane exactly
 * each lane processes input handling, records, and stores information
 * regarding the times that the player hits each Note
 * The information is passed into the LaneManager, to which the Lane has a reference
 */
package com.badlogic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Lane {

    // timing
    LaneManager laneManager;
    Array<Note> notes;

    // input handling
    int keyCode;
    int[] colorKeyCodes;
    boolean ready;
    boolean pressed;
    boolean colorKeyPressed;

    // graphical
    Sprite sprite;
    Rectangle box;
    Color currentColor;
    Color color;
    Color altColor;

    public Lane(LaneManager laneManager, int keyCode, int[] colorKeyCodes) {

        this.laneManager = laneManager;
        this.keyCode = keyCode;
        this.colorKeyCodes = colorKeyCodes;

        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/sprites/lane.png")));
        box = new Rectangle(0, Gdx.graphics.getHeight(), 0, Gdx.graphics.getHeight());
        box.x += laneManager.box.x;
        box.y = 800 - 7*4;

        color = Color.valueOf("ff4466");
        altColor = Color.valueOf("4466ff");
        currentColor = color;

        sprite.setColor(currentColor);
        sprite.flip(false, true);
        sprite.setScale(4);
        sprite.setOrigin(0, 0);
        sprite.setPosition(box.x, box.y - sprite.getHeight() * sprite.getScaleY());

        notes = new Array<Note>();

        update();

    }

    public void record(int time) {

        time = Math.abs(time);

        if (time <= LaneManager.VIVID) {
            laneManager.noteCount += 1;
            laneManager.scores.add("VIVID");
        }
        else if (time <= LaneManager.CLEAR) {
            laneManager.noteCount += 1;
            laneManager.scores.add("CLEAR");
        }
        else if (time <= LaneManager.HAZY) {
            laneManager.noteCount += 1;
            laneManager.scores.add("HAZY");
        }
        else {
            laneManager.noteCount = 0;
            laneManager.scores.add("DULL");
        }

        laneManager.insertScore(laneManager.scores.get(laneManager.scores.size - 1));

    }

    // handles inputs
    // records input times for when player hits notes, and judges whether they are hit correctly
    public void update() {

        // handle inputs
        // color swapping
        if (Gdx.input.isKeyPressed(colorKeyCodes[0]) || Gdx.input.isKeyPressed(colorKeyCodes[1])) {
            if (!colorKeyPressed) {
                if (currentColor.equals(color)) {
                    currentColor = altColor;
                } else {
                    currentColor = color;
                }
                sprite.setColor(currentColor);
            }
            colorKeyPressed = true;
        }
        else {
            colorKeyPressed = false;
        }

        // note hitting
        // key released
        if (Gdx.input.isKeyPressed(keyCode)) {
            pressed = true;
        }
        else {
            ready = true;
            pressed = false;
        }

        // update notes
        for (int i = 0; i < Math.min(10, notes.size); i++) {
            notes.get(i).update();
        }

        // handle 0th note
        if (notes.size > 0) {

            Note note0 = notes.get(0);

            // handle hit note
            if (!(note0 instanceof HoldNote)) {

                // hit note
                if (ready && pressed && !note0.judged && currentColor.equals(note0.color) && note0.getJudgementTime() > -LaneManager.DULL) {
                    ready = false;
                    note0.judged = true;
                    record(note0.getJudgementTime());
                }

                // missed note
                if (!note0.judged && note0.getJudgementTime() > LaneManager.HAZY) {
                    note0.judged = true;
                    record(note0.getJudgementTime());
                }

                // remove judged notes
                if (note0.judged) {
                    notes.removeIndex(0);
                }

            }

            //handle hold note
            else {

                HoldNote hold0 = ((HoldNote) note0);

                // hit head
                if (ready && pressed && !note0.judged && currentColor.equals(note0.color) && note0.getJudgementTime() > -LaneManager.DULL) {
                    ready = false;
                    note0.judged = true;
                    record(note0.getJudgementTime());
                }

                // finish hold
                if (note0.judged && !hold0.tail.judged && pressed && hold0.tail.getJudgementTime() > -LaneManager.VIVID) {
                    hold0.tail.judged = true;
                    record(hold0.tail.getJudgementTime());
                }

                // let go during hold
                if (note0.judged && !hold0.tail.judged && !pressed) {
                    hold0.tail.judged = true;
                    note0.sprite.setColor(Color.DARK_GRAY);
                    record(hold0.tail.getJudgementTime());
                }

                // miss head
                if (!note0.judged && note0.getJudgementTime() > LaneManager.HAZY) {
                    note0.judged = true;
                    hold0.tail.judged = true;
                    note0.sprite.setColor(Color.DARK_GRAY);
                    record(note0.getJudgementTime());
                }

                // miss tail
                //if (!hold0.tail.judged && hold0.tail.getJudgementTime() > LaneManager.HAZY) {
                //    hold0.tail.judged = true;
                //    record(hold0.tail.getJudgementTime());
                //}

                // pressed color change
                if (note0.judged && !hold0.tail.judged && pressed) {
                    note0.sprite.setColor(Color.WHITE);
                }

                // remove completed hold notes
                if (note0.judged && hold0.tail.judged && hold0.tail.getJudgementTime() > LaneManager.HAZY) {
                    notes.removeIndex(0);
                }

            }

        }

        // graphical
        sprite.setPosition(box.x, box.y - sprite.getHeight() * sprite.getScaleY());

        // make lane light up when pressed
        if (pressed) {
            sprite.setTexture(new Texture(Gdx.files.internal("graphics/sprites/lane_hit.png")));
        }
        else {
            sprite.setTexture(new Texture(Gdx.files.internal("graphics/sprites/lane.png")));
        }

    }

    public void draw(SpriteBatch batch) {

        // only draw the 10 most upcoming notes
        for (int i = 0; i < Math.min(10, notes.size); i++) {
            notes.get(i).draw(batch);
        }

        sprite.draw(batch);

    }

}

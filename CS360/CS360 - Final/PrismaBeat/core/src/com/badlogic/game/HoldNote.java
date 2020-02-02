/**
 * Stores information about two Notes to make a HoldNote
 * The handling of these notes is found in the Lane class
 */
package com.badlogic.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HoldNote extends Note {

    Note tail;
    Sprite headSprite;
    float heightDifference = 0;

    public HoldNote(LaneManager laneManager, int laneNumber, float head, boolean altColor) {

        super(laneManager, laneNumber, head, altColor);
        super.sprite.setTexture(Note.holdNoteTexture);
        this.tail = new Note(laneManager, laneNumber, 100, altColor);
        headSprite = new Sprite();

    }

    public void setTail(float beat) {

        tail = new Note(laneManager, laneNumber, beat, false);
        tail.sprite.setColor(super.sprite.getColor());
        laneManager.lanes[laneNumber].notes.add(tail);
        headSprite = new Sprite(this.tail.sprite);
        headSprite.setColor(super.sprite.getColor());
        headSprite.setY(super.sprite.getY());

        // stretch sprite, flips it around
        // sprite is translated up by previous height of sprite
        heightDifference = -((tail.sprite.getY() - super.sprite.getY() - super.sprite.getHeight() * super.sprite.getScaleY())) / super.sprite.getScaleY();
        super.sprite.setSize(super.sprite.getWidth(), heightDifference);

    }

    @Override
    public void draw(SpriteBatch batch) {
        // readjust stretched sprite
        //super.sprite.setY(super.sprite.getY() + super.sprite.getWidth() * (super.sprite.getScaleX() / 4));
        super.sprite.setY(tail.sprite.getY());
        tail.sprite.setColor(super.sprite.getColor());
        super.draw(batch);
        headSprite.setColor(super.sprite.getColor());
        headSprite.setY(tail.sprite.getY() + super.sprite.getHeight() * super.sprite.getScaleY() - headSprite.getHeight() * headSprite.getScaleY());
        headSprite.draw(batch);
    }

}

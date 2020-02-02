/**
 * Keeps track of information about a single Note
 * Where it will be drawn and at what time it will come up in the song
 */
package com.badlogic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Note implements Comparable<Note> {
    LaneManager laneManager;
    SongManager songManager;
    Lane lane;
    int laneNumber;

    // judgement
    float beat;
    double positionInSeconds;
    boolean judged;
    Color color;

    // note textures, static so that there aren't hundreds of the same note textures
    static Texture noteTexture = new Texture(Gdx.files.internal("graphics/sprites/note.png"));
    static Texture holdNoteTexture = new Texture(Gdx.files.internal("graphics/sprites/hold_note.png"));

    // graphical
    Sprite sprite;
    Rectangle box;
    int yMax;

    public Note(LaneManager laneManager, int laneNumber, float beat, boolean altColor) {

        this.laneManager = laneManager;
        songManager = laneManager.songManager;
        this.laneNumber = laneNumber;
        this.lane = laneManager.lanes[laneNumber];
        this.beat = beat;

        positionInSeconds = beat * songManager.secondsPerBeat + songManager.offset / 1000f;
        judged = false;

        // set correct colors
        color = laneManager.lanes[0].color;
        if (altColor)
            color = laneManager.lanes[0].altColor;

        sprite = new Sprite(noteTexture);
        box = new Rectangle(0, 0, 0, 0);
        box.x += lane.box.x;
        box.y += lane.box.y;
        yMax = 800 - 7*4;//(int)(Gdx.graphics.getHeight() - lane.sprite.getHeight() * lane.sprite.getScaleY());

        sprite.setColor(this.color);
        sprite.flip(false, true);
        sprite.setScale(lane.sprite.getScaleX());
        sprite.setOrigin(0, 0);

        update();

    }

    // in milliseconds
    public int getJudgementTime() {
        return (int)((System.nanoTime() - this.songManager.timeStart) / 1000000f - positionInSeconds * 1000);
    }

    public void update() {
        box.y = (float)(yMax - ((positionInSeconds - songManager.songPosition)) * laneManager.noteSpeed);
        sprite.setPosition(box.x, box.y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    // TODO - no implemetation of this is used yet, was going to be used in calculating timing for color switch warnings
    public int compareTo(Note other) {
        if (beat == other.beat) return 0;
        return (beat > other.beat) ? 1 : -1;
    }

}

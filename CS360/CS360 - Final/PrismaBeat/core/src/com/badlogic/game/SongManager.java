/**
 * This class is used to keep track of song positions
 * With the BPM and offset uploaded into the class, it is used to direct the positions
 * of notes when player is playing a chart
 */
package com.badlogic.game;

public class SongManager {

    // timing
    public float bpm;
    public float offset; // in milliseconds

    public float songPosition; // in seconds
    public float songPositionInBeats;
    public float secondsPerBeat;
    public long timeStart;

    public SongManager(float bpm, long offset) {

        this.bpm = bpm;
        this.offset = offset;

        secondsPerBeat = 60f / bpm;
        timeStart = System.nanoTime() + offset * 1000000 + 2500000000l; // in nanoseconds

    }

    public void update() {

        songPosition = (System.nanoTime() - timeStart) / 1000000000f;
        songPositionInBeats = songPosition / secondsPerBeat;

    }

}

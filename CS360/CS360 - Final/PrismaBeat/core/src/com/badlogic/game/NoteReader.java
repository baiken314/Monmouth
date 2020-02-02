package com.badlogic.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NoteReader {

    // song information
    String songFileName;
    String songTitle;
    String artist;
    float bpm;
    long offset;
    int difficulty;

    // note information
    String stream;
    Array<Float>[] noteTimes;
    Array<Character>[] noteTypes;
    Array<Boolean>[] noteColors;

    // color information
    boolean leftAltColor;
    boolean rightAltColor;
    String colorHex;
    String altColorHex;

    // reads in notes from txt file
    public NoteReader(String fileName) {

        leftAltColor = false;
        rightAltColor = false;

        stream = "";
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                stream += scanner.nextLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // separate all notes
        String[] segments = stream.split(",");

        // get song information
        songFileName = segments[0];
        songTitle = segments[1];
        artist = segments[2];
        bpm = Float.parseFloat(segments[3]);
        offset = Long.parseLong(segments[4]);
        difficulty = Integer.parseInt(segments[5]);
        colorHex = segments[6];
        altColorHex = segments[7];

        // get measures
        String[] measures = Arrays.copyOfRange(segments, 8, segments.length);

        // initialize arrays for notes and types
        noteTimes = new Array[4];
        noteTypes = new Array[4];
        noteColors = new Array[4];
        for (int i = 0; i < noteTimes.length; i++) {
            noteTimes[i] = new Array<Float>();
            noteTypes[i] = new Array<Character>();
            noteColors[i] = new Array<Boolean>();
        }

        // go through each measure
        for (int i = 0; i < measures.length; i++) {

            int measure = i; // 4 beats
            float interval = 4f / measures[i].length(); // 4 characters per note

            // go through each beat
            for (int j = 0; j < measures[i].length(); j += 4) {

                float beatTime = measure * 4 + interval * j;
                String note = measures[i].substring(j, j + 4);

                // go through each beat, check if color change
                // M000 = left color change, 000M = right color change
                // M00M = both color changes
                if (note.equals("M000")) {
                    leftAltColor = !leftAltColor;
                }
                if (note.equals("000M")) {
                    rightAltColor = !rightAltColor;
                }
                if (note.equals("M00M")) {
                    leftAltColor = !leftAltColor;
                    rightAltColor = !rightAltColor;
                }

                // go through each lane
                for (int k = 0; k < 4; k++) {
                    if (note.charAt(k) != '0') {

                        noteTimes[k].add(beatTime);
                        noteTypes[k].add(note.charAt(k));

                        // append colors to each side, 0-1 left, 2-3 right
                        if (k <= 1) {
                            noteColors[k].add(leftAltColor);
                        }
                        else {
                            noteColors[k].add(rightAltColor);
                        }

                    }
                }

            }

        }

    }

    // inputs notes read in from file into LaneManager
    public void putNotesIntoLaneManager(LaneManager laneManager) {

        for (int i = 0; i < 4; i++) {
            // cover art
            laneManager.albumCover.setTexture(new Texture("graphics/album_covers/" + songFileName.substring(0, songFileName.length() - 3) + "png"));
            Array<Float> laneNoteTimes = noteTimes[i];
            Array<Character> laneNoteTypes = noteTypes[i];
            Array<Boolean> laneNoteColors = noteColors[i];
            // colors
            laneManager.lanes[i].color = Color.valueOf(colorHex);
            laneManager.lanes[i].altColor = Color.valueOf(altColorHex);
            laneManager.lanes[i].currentColor = Color.valueOf(colorHex);
            laneManager.lanes[i].sprite.setColor(Color.valueOf(colorHex));
            // note times
            for (int j = 0; j < laneNoteTimes.size; j++) {
                if (laneNoteTypes.get(j) == '1') {
                    laneManager.lanes[i].notes.add(new Note(laneManager, i, laneNoteTimes.get(j), laneNoteColors.get(j)));
                }
                if (laneNoteTypes.get(j) == '2') {
                    laneManager.lanes[i].notes.add(new HoldNote(laneManager, i, laneNoteTimes.get(j), laneNoteColors.get(j)));
                }
                if (laneNoteTypes.get(j) == '3') {
                    ((HoldNote)(laneManager.lanes[i].notes.get(laneManager.lanes[i].notes.size - 1))).setTail(laneNoteTimes.get(j));
                }
            }
        }

    }

}

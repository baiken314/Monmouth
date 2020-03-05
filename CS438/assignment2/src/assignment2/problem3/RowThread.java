package assignment2.problem3;

import java.util.ArrayList;

public class RowThread extends Thread {

    private int[] row;

    private int min;
    private int minIndex;

    public RowThread(int[] row) {
        this.row = row;
        min = row[0];
        minIndex = 0;
    }

    public int getMin() { return min; }

    public void run() {
        for (int i = 0; i < row.length; i++) {
            if (row[i] < min) {
                min = row[i];
                minIndex = i;
            }
        }
    }

}

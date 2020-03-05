package assignment2.problem3;

public class ColumnThread extends Thread {

    public int[] col;

    private int max;
    private int maxIndex;

    public ColumnThread(int[] col) {
        this.col = col;
        max = col[0];
        maxIndex = 0;
    }

    public int getMax() { return max; }

    public void run() {
        for (int i = 0; i < col.length; i++) {
            if (col[i] > max) {
                max = col[i];
                maxIndex = i;
            }
        }
    }

}

package assignment2.problem3;

public class RowThread extends Thread {

    private int[] row;

    private int min;

    public RowThread(int[] row) {
        this.row = row;
        min = row[0];
    }

    public int getMin() { return min; }

    public void run() {
        for (int i = 0; i < row.length; i++) {
            if (row[i] < min) {
                min = row[i];
            }
        }
    }

}

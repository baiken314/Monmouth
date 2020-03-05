package assignment2.problem2;

public class MatrixThread extends Thread {

    private int[] matrixRow;
    private int[] matrixCol;

    private int result;

    public MatrixThread(int[] matrixRow, int[] matrixCol) {
        this.matrixRow = matrixRow;
        this.matrixCol = matrixCol;
        result = 0;
    }

    public int getResult() { return result; }

    public void run() {
        // calculate product of the matrixes' row and column
        for (int i = 0; i < matrixRow.length; i++) {
            result += matrixRow[i] * matrixCol[i];
        }
    }

}

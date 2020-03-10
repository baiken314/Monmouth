package assignment2.problem3;

public class Problem3 {

    public static void main(String[] args) throws InterruptedException {

        int[][] matrix = {
                {3, 7, 2, 3, 2},
                {8, 6, 4, 8, 8},
                {6, 6, 3, 2, 8},
                {5, 6, 2, 3, 2} };

        RowThread[] rowThreads = new RowThread[matrix.length];
        ColumnThread[] columnThreads = new ColumnThread[matrix[0].length];

        // initialize RowThreads
        for (int i = 0; i < matrix.length; i++) {
            rowThreads[i] = new RowThread(matrix[i]);
        }

        // initialize ColumnThreads
        for (int i = 0; i < matrix[0].length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            columnThreads[i] = new ColumnThread(column);
        }

        // start threads
        for (int i = 0; i < rowThreads.length; i++) {
            rowThreads[i].start();
        }
        for (int i = 0; i < columnThreads.length; i++) {
            columnThreads[i].start();
        }

        // join threads
        for (int i = 0; i < rowThreads.length; i++) {
            rowThreads[i].join();
        }
        for (int i = 0; i < columnThreads.length; i++) {
            columnThreads[i].join();
        }

        System.out.println("Matrix M");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // loop through mins of each row and maxs of each col
        boolean saddleExists = false;
        for (int row = 0; row < rowThreads.length; row++) {
            if (saddleExists) break;
            for (int col = 0; col < columnThreads.length; col++) {
                if (rowThreads[row].getMin() == columnThreads[col].getMax()) {
                    System.out.println("The saddle point is in M[" + row + "," + col + "] = " + rowThreads[row].getMin());
                    saddleExists = true;
                    break;
                }
            }
        }

        if (!saddleExists) {
            System.out.println("No saddle point exists in Matrix M.");
        }

    }

}
/**
 Matrix M
 3	7	2	3	2
 3	2	9	2	2
 6	5	6	4	8
 5	2	2	3	2

 The saddle point is in M[2,3] = 4
 */
package assignment2.problem2;

public class Problem2 {

    public static void main(String[] args) throws InterruptedException {

        // initialize matrixes
        int[][] matrixA = {
                {3, 7},
                {3, 2},
                {6, 5},
                {4, 8} };
        int[][] matrixB = {
                {3, 7, 2},
                {3, 2, 9} };

        // initialize MatrixThread array
        MatrixThread[][] matrixThreadMatrix = new MatrixThread[matrixA.length][matrixB[0].length];
        for (int row = 0; row < matrixThreadMatrix.length; row++) {
            for (int col = 0; col < matrixThreadMatrix[row].length; col++) {
                // get column of matrixB
                int[] matrixBCol = new int[matrixA[row].length];
                for (int i = 0; i < matrixBCol.length; i++) {
                    matrixBCol[i] = matrixB[i][col];
                }
                // initialize new MatrixThread with row and column
                matrixThreadMatrix[row][col] = new MatrixThread(matrixA[row], matrixBCol);
            }
        }

        // start all threads
        for (int row = 0; row < matrixThreadMatrix.length; row++) {
            for (int col = 0; col < matrixThreadMatrix[row].length; col++) {
                matrixThreadMatrix[row][col].start();
            }
        }

        // join all threads
        for (int row = 0; row < matrixThreadMatrix.length; row++) {
            for (int col = 0; col < matrixThreadMatrix[row].length; col++) {
                matrixThreadMatrix[row][col].join();
            }
        }

        // get product
        int[][] product = new int[matrixThreadMatrix.length][matrixThreadMatrix[0].length];
        for (int row = 0; row < matrixThreadMatrix.length; row++) {
            for (int col = 0; col < matrixThreadMatrix[row].length; col++) {
                product[row][col] = matrixThreadMatrix[row][col].getResult();
            }
        }

        // print matrixes
        printMatrix(matrixA, "A");
        printMatrix(matrixB, "B");
        printMatrix(product, "C");

    }

    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("Matrix " + name);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
/**
 Matrix A
 3	7
 3	2
 6	5
 4	8

 Matrix B
 3	7	2
 3	2	9

 Matrix C
 30	35	69
 15	25	24
 33	52	57
 36	44	80
 */
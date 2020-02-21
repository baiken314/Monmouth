package assignment2;

public class Problem1 {

    public static void main(String[] args) throws InterruptedException {

        int from = 27;
        int to = 100;

        int numberOfThreads = 4;
        int subLength = (to - from + 1) / numberOfThreads;

        PrimeNumberThread[] pnthreads = new PrimeNumberThread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int start = subLength * i + from;
            int end = (i < numberOfThreads - 1) ? subLength * (i + 1) + from - 1 : to;
            pnthreads[i] = new PrimeNumberThread(start, end);
        }

        for (int i = 0; i < numberOfThreads; i++) {
            pnthreads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            pnthreads[i].join();
        }

        int totalNumberOfPrimes = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            totalNumberOfPrimes += pnthreads[i].getNumberOfPrimeNumbers();
            //System.out.println(pnthreads[i].primeNumbers.toString());
        }

        System.out.println("Total number of prime numbers: " + totalNumberOfPrimes);
        System.out.println("END");

    }

}

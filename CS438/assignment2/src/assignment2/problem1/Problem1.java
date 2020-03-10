package assignment2.problem1;

public class Problem1 {

    public static void main(String[] args) throws InterruptedException {

        int from = 1;
        int to = 20;

        int numberOfThreads = 3;
        int subLength = (to - from + 1) / numberOfThreads;

        PrimeNumberThread[] pnthreads = new PrimeNumberThread[numberOfThreads];

        // setup and create threads
        for (int i = 0; i < numberOfThreads; i++) {
            int subFrom = subLength * i + from;
            int subTo = (i < numberOfThreads - 1) ? subFrom + subLength - 1 : to;
            pnthreads[i] = new PrimeNumberThread("Thread-" + i, subFrom, subTo);
        }

        // start threads
        for (int i = 0; i < numberOfThreads; i++) {
            pnthreads[i].start();
        }

        // wait for all threads to finish
        for (int i = 0; i < numberOfThreads; i++) {
            pnthreads[i].join();
        }

        int totalNumberOfPrimeNumbers = 0;

        // add all amounts of primes
        for (int i = 0; i < numberOfThreads; i++) {
            totalNumberOfPrimeNumbers += pnthreads[i].getNumberOfPrimeNumbers();
        }

        // print out all numbers
        System.out.println();
        for (int i = 0; i < numberOfThreads; i++) {
            pnthreads[i].print();
        }

        System.out.println("\nTotal number of prime numbers found: " + totalNumberOfPrimeNumbers);

    }

}
/**
 Thread-0 [1,6] started!
 Thread-1 [7,12] started!
 Thread-2 [13,20] started!
 Thread-2 [13,20] completed!
 Thread-0 [1,6] completed!
 Thread-1 [7,12] completed!

 Thread-0 [1,6] : prime numbers found = [2, 3, 5]
 Thread-1 [7,12] : prime numbers found = [7, 11]
 Thread-2 [13,20] : prime numbers found = [13, 17, 19]

 Total number of prime numbers found: 8
 */
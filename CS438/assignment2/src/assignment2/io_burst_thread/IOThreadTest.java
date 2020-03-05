package assignment2.io_burst_thread;

public class IOThreadTest {

    public static void main(String[] args) throws InterruptedException {

        int from = 1;
        int to = 50000;

        int numberOfThreads = 128;
        int subLength = (to - from + 1) / numberOfThreads;

        IOPrimeNumberThread[] pnthreads = new IOPrimeNumberThread[numberOfThreads];

        // setup and create threads
        for (int i = 0; i < numberOfThreads; i++) {
            int subFrom = subLength * i + from;
            int subTo = (i < numberOfThreads - 1) ? subFrom + subLength - 1 : to;
            pnthreads[i] = new IOPrimeNumberThread("Thread-" + i, subFrom, subTo);
        }

        long startTime = System.currentTimeMillis();

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
            //System.out.println(pnthreads[i].primeNumbers.toString());
        }

        long endTime = System.currentTimeMillis() - startTime;

        System.out.println("Total number of prime numbers: " + totalNumberOfPrimeNumbers);
        System.out.println("END after " + endTime / 1000f + "s");

    }

}

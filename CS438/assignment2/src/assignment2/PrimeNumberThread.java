package assignment2;

import java.util.ArrayList;

public class PrimeNumberThread extends Thread {

    private int begin, end;
    private int numberOfPrimeNumbers;
    public ArrayList<Integer> primeNumbers;

    public PrimeNumberThread(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
        primeNumbers = new ArrayList<>();
    }

    public int getNumberOfPrimeNumbers() { return numberOfPrimeNumbers; }

    public void run() {
        System.out.println("Thread [" + begin + "," + end + "] started.");
        boolean isPrime;
        for (int i = begin; i <= end; i++) {
            isPrime = true;
            for (int divisor = 2; divisor < i; divisor++) {
                if (i % divisor == 0) {
                    isPrime = false;
                    break; // stop checking after already false
                }
            }
            if (isPrime) {
                numberOfPrimeNumbers += 1;
                primeNumbers.add(i);
            }
        }
        System.out.println("Thread [" + begin + "," + end + "] finished with " + numberOfPrimeNumbers + " prime number(s).");
    }

}

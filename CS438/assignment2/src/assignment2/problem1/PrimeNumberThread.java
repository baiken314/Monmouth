package assignment2.problem1;

import java.util.ArrayList;
import java.util.Random;

public class PrimeNumberThread extends Thread {

    private int begin, end;
    private int numberOfPrimeNumbers;
    public ArrayList<Integer> primeNumbers;

    public static Random random = new Random(); // used to simulate random waiting time

    public PrimeNumberThread(String name, int begin, int end) {
        setName(name);
        this.begin = begin;
        this.end = end;
        primeNumbers = new ArrayList<>();
    }

    public int getNumberOfPrimeNumbers() { return numberOfPrimeNumbers; }

    public void run() {
        System.out.println(getName() + " [" + begin + "," + end + "] started.");
        boolean isPrime;
        // check all numbers in range
        for (int i = Math.max(begin, 2); i <= end; i++) {
            isPrime = true;
            // calculate whether number is prime
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
        System.out.println(getName() + " [" + begin + "," + end + "] finished with " + numberOfPrimeNumbers + " prime number(s).");
    }

}

package assignment1;

import java.util.Arrays;

public class Problem3 {
	
	// keep track of when threads finish
	public static final long startTime = System.nanoTime();
	
	public static void main(String[] args) throws InterruptedException {
		
		// initialize arrays and ranges
		int[] a = { 1, 3, 4, 2, 5, 4, 2, 1, 5, 3 };
		int[] b = { 6, 9, 8, 10, 7, 9, 6, 8, 7, 10 };
		int[] froms = { 0, 3, 6 };
		int[] tos = { 3, 6, 10 };
		
		// initialize ArrayProductThreads
		ArrayProductThread[] apts = new ArrayProductThread[froms.length];
		
		for (int i = 0; i < froms.length; i++) {
			apts[i] = new ArrayProductThread("T" + i,
				Arrays.copyOfRange(a, froms[i], tos[i]),
				Arrays.copyOfRange(b, froms[i], tos[i]));
			apts[i].start(); // start threads
		}
		
		for (int i = 0; i < apts.length; i++) {
			apts[i].join(); // do not multiply products until all have finished
		}
		
		// calculate final product after joining all other threads
		long finalProduct = apts[0].getProduct();
		for (int i = 1; i < apts.length; i++) {
			finalProduct *= apts[i].getProduct();
		}
		
		System.out.println("Final product: " + apts[0].getProduct() + " * " + apts[1].getProduct() + " * " + apts[2].getProduct() + " = " + finalProduct + ", at time: " + (System.nanoTime() - startTime) + "ns");
		
	}
	
}

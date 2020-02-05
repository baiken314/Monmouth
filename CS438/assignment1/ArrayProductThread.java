package assignment1;

import java.util.ArrayUtils;

public class ArrayProductThread extends Thread {
	
	private int product;
	private int[] ints;
	
	public ArrayProductThread(int[] a, int[] b) {
		
		product = 0;
		ints = ArrayUtils.addAll(a, b);
		
	}
	
	public int getProduct() { return product; }
	
	public void run() {
		product = ints[0];
		for (int i = 1; i < ints.length; i++) {
			product *= ints[i];
		}
		System.out.println("Thread product: " + product);
	}
	
}

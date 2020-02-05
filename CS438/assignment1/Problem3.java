package assignment1;

import java.util.Arrays;

public class Problem3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] a = { 1, 3, 4, 2, 5, 4, 2, 1, 5, 3 };
		int[] b = { 6, 9, 8, 10, 7, 9, 6, 8, 7, 10 };
		int[] froms = { 0, 3, 6 };
		int[] tos = { 3, 6, 10 };
		
		ArrayProductThread[] apts = new ArrayProductThread[froms.length];
		
		for (int i = 0; i < froms.length; i++) {
			apts[i] = new ArrayProductThread(
				Arrays.copyOfRange(a, froms[i], tos[i]),
				Arrays.copyOfRange(b, froms[i], tos[i])
				);
			apts[i].start();
		}
		
		for (int i = 0; i < apts.length; i++) {
			apts[i].join();
		}
		
	}
	
}

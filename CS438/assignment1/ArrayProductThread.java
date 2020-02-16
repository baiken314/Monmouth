package assignment1;

public class ArrayProductThread extends Thread {
	
	private int product;
	private int[] ints;
	private String intsString;
	
	public ArrayProductThread(String name, int[] a, int[] b) {
		
		setName(name);
		
		product = 0;
		ints = new int[a.length + b.length];
		intsString = "[ ";
		
		// copy a and b contents into ints
		for (int i = 0; i < a.length; i++) {
			ints[(i*2)] = a[i];
			intsString += a[i] + ", ";
			ints[(i*2)+1] = b[i];
			intsString += b[i] + ", ";
		}
		intsString += "\b\b ]";
		
	}
	
	public int getProduct() { return product; }
	
	public void run() {
		
		System.out.println("Thread " + getName() + " " + intsString + " started at " + (System.nanoTime() - Problem3.startTime) + "ns");
		
		// multiply all contents
		product = ints[0];
		for (int i = 1; i < ints.length; i++) {
			product *= ints[i];
		}
		
		System.out.println("Thread " + getName() +  " " + intsString + " product: " + product + ", at time: " + (System.nanoTime() - Problem3.startTime) + "ns");
		
	}
	
}

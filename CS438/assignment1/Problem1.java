package assignment1;

public class Problem1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new MyThread("C");
		Thread t2 = new MyThread("B");
		t1.start();
		t2.start();
		t1.join();
		System.out.println("MAIN");
	
	}

}

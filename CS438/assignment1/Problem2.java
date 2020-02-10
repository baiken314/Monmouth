package assignment1;

public class Problem2 {
	
	private static int x = 0;
	
	public static void main(String[] args) throws InterruptedException {
	
		Problem2Thread t1 = new Problem2Thread("t1");
		Problem2Thread t2 = new Problem2Thread("t2");
		method1();
		t1.start();
		t1.join();
		method2();
		t2.start();
		t2.join();
		method1();
		
	}
	
	public static void method1() {
		x += 1;
		Thread t1 = Thread.currentThread();
		System.out.println("X=" + x + " Name=" + t1.getName() + " State=" + t1.getState());
	}

	public static void method2() {
		Thread t2 = Thread.currentThread();
		System.out.println("X=" + x + " Name=" + t2.getName() + " State=" + t2.getState());
		x += 1;
	}
	
}

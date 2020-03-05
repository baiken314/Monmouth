package hello_thread;

public class HelloThreadTest {
	
	public static void main(String[] args) {
		
		HelloThread h1 = new HelloThread("First thread");
		HelloThread h2 = new HelloThread("Second thread");
		h1.start();
		h2.start();
		System.out.println("END");
		
	}

}
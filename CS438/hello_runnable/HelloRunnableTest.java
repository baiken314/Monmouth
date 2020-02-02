package hello_runnable;

public class HelloRunnableTest {
	
	public static void main(String[] args) {
		
		HelloRunnable hr1 = new HelloRunnable("First runnable thread");
		HelloRunnable hr2 = new HelloRunnable("Second runnable thread");
		Thread t1 = new Thread(hr1);
		Thread t2 = new Thread(hr2);
		t1.start();
		t2.start();
		System.out.println("END");
		
	}
	
}

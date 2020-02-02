package hello_thread;

public class HelloThread extends Thread {
	
	public HelloThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello from " + getName());
		}
	}
	
}

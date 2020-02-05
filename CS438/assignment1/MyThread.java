package assignment1;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(getName());
		}
	}
	
}

package assignment1;

public class Problem2Thread extends Thread {
	
	int x;
	
	public Problem2Thread(String name) {
		setName(name);
		x = 0;
	}
	
	public void run() {
		System.out.println("X=" + x + " Name=" + getName() + " State=" + getState());
		x += 1;
	}
	
}

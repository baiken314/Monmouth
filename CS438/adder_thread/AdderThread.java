package adder_thread;

public class AdderThread extends Thread {
	
	private int from;
	private int to;
	private int sum;
	
	public AdderThread(int from, int to) {
		this.from = from;
		this.to = to;
		sum = 0;
	}
	
	public int getSum() { return sum; }
	
	public void run() {
		System.out.println("Adding from " + from + " to " + to + " started!");
		for (int i = from; i <= to; i++) {
			sum += i;
		}
		System.out.println("Adding from " + from + " to " + to + " finished!");
	}
	
}

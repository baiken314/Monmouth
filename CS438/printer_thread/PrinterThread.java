package printer_thread;

public class PrinterThread extends Thread {

	private int from;
	private int to;
	
	public PrinterThread(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public void run() {
		for (int i = from; i <= to; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}

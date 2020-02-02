package printer_thread;

public class PrinterThreadTest {
	
	public static void main(String[] args) {
		
		PrinterThread p1 = new PrinterThread(0, 10);
		PrinterThread p2 = new PrinterThread(11, 20);
		p1.start();
		p2.start();
		System.out.println("END");
		
	}
	
}

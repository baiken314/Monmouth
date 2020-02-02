package printer_seq;

public class PrinterSeq {
	
	private int from;
	private int to;
	
	public PrinterSeq(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public void print() {
		for (int i = from; i <= to; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}

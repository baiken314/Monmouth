package printer_seq;

public class PrinterSeqTest {
	
	public static void main(String[] args) {
		
		PrinterSeq p1 = new PrinterSeq(0, 10);
		PrinterSeq p2 = new PrinterSeq(11, 20);
		p1.print();
		p2.print();
		System.out.println("END");
		
	}
	
}

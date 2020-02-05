package adder_thread;

public class AdderThreadTest {
	
	public static void main(String[] args) {
		
		int from = 1;
		int to = 100;
		int middle = (from + to) / 2;
		AdderThread a1 = new AdderThread(from, middle);
		AdderThread a2 = new AdderThread(middle + 1, to);
		
		try {
			a1.start();
			System.out.println("a1 start");
			a2.start();
			System.out.println("a2 start");
			a1.join();
			System.out.println("a1 finish, sum: " + a1.getSum());
			a2.join();
			System.out.println("a2 finish, sum " + a2.getSum());
		}
		catch (Exception e) {}
		
		System.out.println("END SUM: " + (a1.getSum() + a2.getSum()));
		
	}
	
}

package adder_thread;

public class AdderThreadTest {
	
	public static void main(String[] args) {
		
		AdderThread a1 = new AdderThread(0, 10);
		AdderThread a2 = new AdderThread(11, 20);
		
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

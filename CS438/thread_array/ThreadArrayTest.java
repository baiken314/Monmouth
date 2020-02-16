package thread_array;

public class ThreadArrayTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 1, 2, 3, 4, 5, 6 };
		int numberOfThreads = 4;
		
		int s = (a.length / numberOfThreads);
		int n = a.length;
		
		ScalarProductThread threads[] = new ScalarProductThread[numberOfThreads];
		
		int init = -1;
		int end = -1;
		
		for (int i = 0; i < numberOfThreads; i++) {
			
			init = i * s;
			end = (i == numberOfThreads - 1) ? n - 1 : (i + 1) * s - 1;
			
			threads[i] = new ScalarProductThread("T" + i, a, b, init, end);
			threads[i].start();
			
		}
		
		for (int i = 0; i < numberOfThreads; i++) {
			threads[i].join();
		}
		
		int result = 0;
		
		for (int i = 0; i < numberOfThreads; i++) {
			System.out.println("Result " + i + " = " + threads[i].getResult());
			result += threads[i].getResult();
		}
		
		System.out.println("Result = " + result);
		
	}
	
}

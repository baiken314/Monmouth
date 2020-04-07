package semaphore_exercises;

import java.util.concurrent.Semaphore;

public class ABABCSolution {

    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore semC = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    private static int countA, countB = 2;

    public static void main(String[] args) throws Exception {

        while (true) {
            Thread a = new A();
            //Thread b = new B();
            //Thread c = new C();
            a.start();
            //b.start();
            //c.start();
            Thread.sleep(1000);
        }

    }

    static class A extends Thread {
        public void run() {
            //try {
                //semA.acquire();
                //mutex.acquire();
            //}
            //catch
        }
    }

}

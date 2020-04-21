package semaphore_exercises;

import java.util.concurrent.Semaphore;

public class ABABC {

    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore semC = new Semaphore(0);
    //private static Semaphore mutex = new Semaphore(1);

    private static int countA = 0;
    private static int countB = 0;

    public static void main(String[] args) throws Exception {

        while (true) {
            Thread a = new A();
            Thread b = new B();
            Thread c = new C();
            a.start();
            b.start();
            c.start();
            Thread.sleep(1000);
        }

    }

    static class A extends Thread {
        public void run() {
            try {
                semA.acquire();
                //mutex.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            countA += 1;
            System.out.print("A ");
            if (countA == 1 || countA == 2) {
                semB.release(1);
            }
            //mutex.release();
        }
    }

    static class B extends Thread {
        public void run() {
            try {
                semB.acquire();
                //mutex.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            countB += 1;
            System.out.print("B ");
            if (countB == 1) {
                semA.release(1);
            }
            else if (countB == 2) {
                semC.release(1);
            }
            //mutex.release();
        }
    }

    static class C extends Thread {
        public void run() {
            try {
                semC.acquire();
                //mutex.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            countA = 0;
            countB = 0;
            System.out.print("C ");
            semA.release(1);
            //mutex.release();
        }
    }

}

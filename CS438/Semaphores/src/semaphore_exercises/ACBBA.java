package semaphore_exercises;

import java.util.concurrent.Semaphore;

public class ACBBA {

    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore semC = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

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
            }
            catch (Exception e) { e.printStackTrace(); }

            System.out.print("A ");
            countA += 1;

            if (countA == 1) {
                semC.release();
            }
            else if (countA == 2) {
                countA = 0;
                countB = 0;
                semA.release();
            }

        }
    }

    static class B extends Thread {
        public void run() {

            try {
                semB.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }

            System.out.print("B ");

            countB += 1;

            if (countB == 2) {
                semA.release();
            }
            else {
                semB.release();
            }

        }
    }

    static class C extends Thread {
        public void run() {

            try {
                semC.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }

            System.out.print("C ");

            semB.release();

        }

    }

}

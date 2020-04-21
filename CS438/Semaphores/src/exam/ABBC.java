/**
 * Bradley Aiken
 * Question 1-A, ABBC.java
 */
package exam;

import java.util.concurrent.Semaphore;

public class ABBC {

    public static Semaphore semA = new Semaphore(1);
    public static Semaphore semB = new Semaphore(0);
    public static Semaphore semC = new Semaphore(0);

    public static int countB = 0;

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
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("A ");
            semB.release(1);
        }
    }

    static class B extends Thread {
        public void run() {
            try {
                semB.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("B ");
            countB += 1;
            if (countB == 1) { semB.release(1); }
            else { semC.release(1); }
        }
    }

    static class C extends Thread {
        public void run() {
            try {
                semC.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("C ");
            countB = 0;
            semA.release(1);
        }
    }

}

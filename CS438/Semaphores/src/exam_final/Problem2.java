package exam_final;

import java.util.concurrent.Semaphore;

public class Problem2 {

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);
    private static Semaphore semaphoreD = new Semaphore(0);

    private static int countB = 0;
    private static int countD = 0;

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Thread a = new A();
            Thread b = new B();
            Thread c = new C();
            Thread d = new D();
            a.start();
            b.start();
            c.start();
            d.start();
            Thread.sleep(1000);
        }

    }

    static class A extends Thread {
        public void run() {
            try {
                semaphoreA.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("A ");
            semaphoreB.release(1);
        }
    }

    static class B extends Thread {
        public void run() {
            try {
                semaphoreB.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("B ");
            countB += 1;
            if (countB == 2) {
                countB = 0;
                semaphoreC.release(1);
            }
            else {
                semaphoreB.release(1);
            }
        }
    }

    static class C extends Thread {
        public void run() {
            try {
                semaphoreC.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("C ");
            semaphoreD.release(1);
        }
    }

    static class D extends Thread {
        public void run() {
            try {
                semaphoreD.acquire();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.print("D ");
            countD += 1;
            if (countD == 2) {
                countD = 0;
                System.out.print(" ");
                semaphoreA.release(1);
            }
            else {
                semaphoreD.release(1);
            }
        }
    }

}
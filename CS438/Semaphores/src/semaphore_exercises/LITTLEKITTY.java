package semaphore_exercises;

import java.util.concurrent.Semaphore;

public class LITTLEKITTY {

    public static Semaphore semL = new Semaphore(1);
    public static Semaphore semI = new Semaphore(0);
    public static Semaphore semT = new Semaphore(0);
    public static Semaphore semE = new Semaphore(0);
    public static Semaphore semK = new Semaphore(0);
    public static Semaphore semY = new Semaphore(0);

    public static int countL, countT = 0;

    public static void main(String[] args) throws Exception {

        while (true) {
            Thread l = new L();
            Thread i = new I();
            Thread t = new T();
            Thread e = new E();
            Thread k = new K();
            Thread y = new Y();
            l.start();
            i.start();
            t.start();
            e.start();
            k.start();
            y.start();
            Thread.sleep(1000);
        }

    }

    static class L extends Thread {
        public void run() {
            try {
                semL.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("L ");
            countL += 1;
            if (countL == 1) { semI.release(1); }
            else if (countL == 2) { semE.release(1); }
        }
    }

    static class I extends Thread {
        public void run() {
            try {
                semI.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("I ");
            semT.release(1);
        }
    }

    static class T extends Thread {
        public void run() {
            try {
                semT.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("T ");
            countT += 1;
            if (countT == 1 || countT == 3) { semT.release(1); }
            else if (countT == 2) { semL.release(1); }
            else if (countT == 4) { semY.release(1); }
        }
    }

    static class E extends Thread {
        public void run() {
            try {
                semE.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("E ");
            semK.release(1);
        }
    }

    static class K extends Thread {
        public void run() {
            try {
                semK.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("K ");
            semI.release(1);
        }
    }

    static class Y extends Thread {
        public void run() {
            try {
                semY.acquire();
            }
            catch (Exception e) { e.printStackTrace(); }
            System.out.print("Y ");
            countL = 0;
            countT = 0;
            semL.release(1);
        }
    }

}

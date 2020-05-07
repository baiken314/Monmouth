package exam_final;

public class Problem1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new MyThread("X ");
        Thread t2 = new MyThread("Y ");
        t1.start();
        t2.start();
        t1.join();
        System.out.print("MAIN ");

    }

}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.print(getName());
        }
    }

}
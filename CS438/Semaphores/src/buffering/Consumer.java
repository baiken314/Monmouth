package buffering;

import java.util.Random;

public class Consumer extends Thread {

    private static int MIN_CONSUMING_TIME = 30;
    private static int MAX_CONSUMING_TIME = 50;

    private Random random = new Random();
    private BoundedBuffer boundedBuffer;

    public Consumer(String name, BoundedBuffer boundedBuffer) {
        super(name);
        this.boundedBuffer = boundedBuffer;
    }

    public void run() {
        try {
            while (true) {
                int item = boundedBuffer.get();
                consumeItem(item);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void consumeItem(int item) throws InterruptedException {
        randomWait(MIN_CONSUMING_TIME, MAX_CONSUMING_TIME);
    }

    private void randomWait(int minTime, int maxTime) throws InterruptedException {
        Thread.sleep(random.nextInt(maxTime - minTime + 1) + minTime);
    }

}

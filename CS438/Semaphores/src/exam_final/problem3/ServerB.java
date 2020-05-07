package exam_final.problem3;

import java.util.Random;

public class ServerB extends Thread {

    private static int MIN_CONSUMING_TIME = 30;
    private static int MAX_CONSUMING_TIME = 50;

    private Random random = new Random();
    private Network network;

    public ServerB(String name, Network network) {
        super(name);
        this.network = network;
    }

    public void run() {
        try {
            while (true) {
                File file = network.receive();
                consumeFile(file);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void consumeFile(File file) throws InterruptedException {
        randomWait(MIN_CONSUMING_TIME, MAX_CONSUMING_TIME);
    }

    private void randomWait(int minTime, int maxTime) throws InterruptedException {
        Thread.sleep(random.nextInt(maxTime - minTime + 1) + minTime);
    }

}

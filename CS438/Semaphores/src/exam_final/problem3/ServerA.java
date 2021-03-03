package exam_final.problem3;

import java.util.Random;

public class ServerA extends Thread {

    private static int MAX_RANDOM = 100;
    private static int MIN_PRODUCING_TIME = 30;
    private static int MAX_PRODUCING_TIME = 50;

    private Random random = new Random();
    private Network boundedBuffer;

    public ServerA(String name, Network boundedBuffer) {
        super(name);
        this.boundedBuffer = boundedBuffer;
    }

    public void run() {
        try {
            while (true) {
                File file = produceFile();
                boundedBuffer.send(file);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private File produceFile() throws InterruptedException {
        randomWait(MIN_PRODUCING_TIME, MAX_PRODUCING_TIME);
        File file = new File(true);
        return file;
    }

    private void randomWait(int minTime, int maxTime) throws InterruptedException {
        Thread.sleep(random.nextInt(maxTime - minTime + 1) + minTime);
    }

}

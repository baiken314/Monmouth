package buffering;

public class BoundedBufferTest {

    public static void main(String[] args) {

        int size = 5;

        BoundedBuffer boundedBuffer = new BoundedBufferSemaphore(size);

        Producer producer = new Producer(Integer.toString(1), boundedBuffer);
        Consumer consumer = new Consumer(Integer.toString(1), boundedBuffer);

        producer.start();
        consumer.start();

    }

}

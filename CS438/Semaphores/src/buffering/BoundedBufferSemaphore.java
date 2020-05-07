package buffering;

import java.util.concurrent.Semaphore;

public class BoundedBufferSemaphore extends BoundedBuffer {

    private Semaphore mutex;
    private Semaphore full;
    private Semaphore empty;

    public BoundedBufferSemaphore(int size) {
        super(size);
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    public void put(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        mutex.release();
        System.out.println("Producer " + Thread.currentThread().getName() +
                " has inserted item " + item + ". " + getContent());
        full.release();
    }

    public int get() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item = buffer[out];
        buffer[out] = -1;
        out = (out + 1) % buffer.length;
        mutex.release();
        System.out.println("Consumer " + Thread.currentThread().getName() +
                " has consumed item " + item + ". " + getContent());
        empty.release();
        return item;
    }

}

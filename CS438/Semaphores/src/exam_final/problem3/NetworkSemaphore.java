package exam_final.problem3;

import java.util.concurrent.Semaphore;

public class NetworkSemaphore extends Network {

    private Semaphore mutex;
    private Semaphore full;
    private Semaphore empty;

    public NetworkSemaphore(int size) {
        super(size);
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    public void send(File file) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        buffer[in] = file;
        in = (in + 1) % buffer.length;
        mutex.release();
        System.out.println("ServerA has sent file with content "
                + file.getContent() + ". " + getContent());
        full.release();
    }

    public File receive() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        File file = buffer[out];
        buffer[out] = new File(false);
        out = (out + 1) % buffer.length;
        mutex.release();
        System.out.println("ServerB has received file with content "
                + file.getContent() + ". " + getContent());
        empty.release();
        return file;
    }

}

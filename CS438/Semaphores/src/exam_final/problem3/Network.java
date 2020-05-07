package exam_final.problem3;

public abstract class Network {

    protected File[] buffer;
    protected int in = 0;
    protected int out = 0;

    public Network(int size) {
        buffer = new File[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new File(false);
        }
    }

    public abstract void send(File file) throws InterruptedException;

    public abstract File receive() throws InterruptedException;

    public String getContent() {
        String string = "[ ";
        for (int i = 0; i < buffer.length; i++) {
            string += buffer[i].getContent() + " ";
        }
        string += "]";
        return string;
    }

}

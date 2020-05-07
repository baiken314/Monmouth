    package exam_final.problem3;

    public class MultiServerTest {

        public static void main(String[] args) {

            int size = 3;
    
            Network network = new NetworkSemaphore(size);

            ServerA serverA = new ServerA(Integer.toString(1), network);
            ServerB serverB = new ServerB(Integer.toString(1), network);

            serverA.start();
            serverB.start();

        }

    }

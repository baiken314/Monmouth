package exam_final.problem3;

public class File {

    private static int count = 0;

    private int content;

    public File(boolean exists) {
        if (exists) {
            content = count;
            count += 1;
        }
        else {
            this.content = -1;
        }
    }

    public int getContent() {
        return content;
    }

}

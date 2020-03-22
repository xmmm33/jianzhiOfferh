package practice;

public class Context {

    private process process;

    public Context(process process1) {
        process = process1;
    }

    public void start() {
        process.process();
    }
}

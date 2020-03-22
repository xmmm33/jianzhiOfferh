package practice;

public abstract class process {
    abstract void before();

    void process() {
        this.before();
        System.out.println("shshshs");
        this.after();
    }

    abstract void after();
}

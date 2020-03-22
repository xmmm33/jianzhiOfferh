package day2;

public class Test extends Thread{
    /*定义一个全局变量 来存放线程需要的变量*/
    private static ThreadLocal<Double> t1 = new ThreadLocal<>();
    private static double a = 8;
    public static void main(String[] args) {
        /*创建两个线程*/
        for(int i=0; i<1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Double d = Math.random()*10;
                    /*存入当前线程独有的值*/
                    t1.set(a);
                    System.out.println(Thread.currentThread() + t1.get().toString());
                    try {
                        sleep(5000);
                        System.out.println(Thread.currentThread() + t1.get().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for(int i=0; i<1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Double d = Math.random()*10;
                    /*存入当前线程独有的值*/
                    t1.set(--a);
                    System.out.println(Thread.currentThread() + t1.get().toString());
                }
            }).start();
        }
    }
    static class A{
        public  void get(){
            /*取得当前线程所需要的值*/
            System.out.println(t1.get());
        }
    }
    static class B{
        public  void get(){
            /*取得当前线程所需要的值*/
        }
    }


}

package day2;

public class Test extends Thread{
    /*定义一个全局变量 来存放线程需要的变量*/
    private static ThreadLocal<Integer> t1 = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> t2 = new ThreadLocal<Integer>();
    public static void main(String[] args) {
        /*创建两个线程*/
        for(int i=0; i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Double d = Math.random()*10;
                    /*存入当前线程独有的值*/
                    t1.set(d.intValue());
                    t2.set((int) (d + 1));
                    System.out.println(Thread.currentThread() + t1.get().toString());
                    System.out.println(Thread.currentThread() + t2.get().toString());
                }
            }).start();
        }
    }
    static class A{
        public  void get(){
            /*取得当前线程所需要的值*/
            System.out.println(t1.get());
            System.out.println(t2.get());
        }
    }
    static class B{
        public  void get(){
            /*取得当前线程所需要的值*/
        }
    }


}

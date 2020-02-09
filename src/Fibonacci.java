/**
 * jianzhioffer-day1
 * @author MSI
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibtwo(13));
    }

    /**
     * 递归实现
     * 斐波拉切数列 0 1 1 2 3 5 8 13
     * 当n很大的时候，会有很多的重复计算
     * @param n
     * @return
     */
    private static int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    /**
     * 循环实现
     * 斐波拉切数列
     * @param n
     * @return
     */
    private static int Fibtwo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int ret = 0;
            int a = 1;
            int b = 0;
            for (int i = 0; i < n - 1; i++) {
                ret = a + b;
                b = a;
                a = ret;
            }
            return ret;
        }
    }
}

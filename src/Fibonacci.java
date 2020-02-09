/**
 * jianzhioffer-day1
 * @author MSI
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibtwo(100));
    }

    /**
     * 递归实现
     * 斐波拉切数列 0 1 1 2 3 5 8 13
     * 当n很大的时候，会有很多的重复计算
     * 时间复杂度：2^n
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
     * 循环实现（推荐方式）
     * 斐波拉切数列
     * 时间复杂度：n
     * @param n
     * @return
     */
    private static long Fibtwo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long ret = 0;
            long a = 1;
            long b = 0;
            for (int i = 0; i < n - 1; i++) {
                ret = a + b;
                b = a;
                a = ret;
            }
            return ret;
        }
    }

}

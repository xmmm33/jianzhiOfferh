/**
 * jianzhioffer-day1
 * @author MSI
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(13));
    }

    /**
     * 斐波拉切数列 0 1 1 2 3 5 8 13
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}

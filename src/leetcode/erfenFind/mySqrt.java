package leetcode.erfenFind;

/**
 * 求一个数的开方
 */
public class mySqrt {

    public static int mySqrt(int x) {
        if (x == 0 || x==1) {
            return x;
        }
        int l = 1;
        int r = x/2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 注意这里要使用long
            long num = (long)mid * mid;
            if (num == x) {
                return mid;
            } else if (num > x) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] a) {
        System.out.println(mySqrt(2147395599));
    }
}

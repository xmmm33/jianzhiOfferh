package jianzhiOffer1;

public class fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }else {
            int res = 0;
            int low = 0;
            int high = 1;
            for (int i = 0; i < n - 1; i++) {
                // 取余是为了防止res过大超过int范围
                res = (low + high)%1000000007;
                low = high;
                high = res;
            }
            return res;
        }
    }
}

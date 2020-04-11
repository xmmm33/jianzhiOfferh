package jianzhiOffer1;

public class numWays {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }else {
            int res = 0;
            int low = 1;
            int high = 1;
            for (int i = 0; i < n - 1; i++) {
                res = (low + high) % 1000000007;
                low = high;
                high = res;
            }
            return res;
        }
    }
}

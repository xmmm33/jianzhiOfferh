package jianzhiOffer1;

public class cuttingRope {

    /**
     * 尽可能分成3
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return (n - 1) % 1000000007;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3;
            res = res % 1000000007;
            n = n - 3;
        }
        return (int) (res * n % 1000000007);
    }
}

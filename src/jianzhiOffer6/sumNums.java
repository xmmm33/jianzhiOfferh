package jianzhiOffer6;

public class sumNums {

    /**
     * 求1到n的和
     * @param n
     * @return
     */
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res = res + n;
        return res;
    }
}

package jianzhiOffer1;

public class hammingWeight {

    public int hammingWeight(int n) {
        int res =0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}

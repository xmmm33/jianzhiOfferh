package jianzhiOffer1;

public class myPow {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        //执行 x = x^2x
        //执行 nn 右移一位（即 n >>= 1n>>=1）
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            b = b / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        myPow(2.00000, -2147483648);
    }
}

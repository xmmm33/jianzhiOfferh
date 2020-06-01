package jindian4;

public class quickMi {

    // 快速幂，用于快速求a的b次方
    // 思路：比如3的10次方；
    // 首先10的二进制表示为1010
    // 那么3的10次方可以表示为：3^(1*2^3) * 3^(0*2^2) * 3^(1*2^1) * 3^(0*2^0)
    public static int quick(int a, int b) {
        int res = 1;
        // base表示的就是a^(x*2^y); x表示的是a的当前二进制位为1还是为0； y表示的是当前基数
        int base = a;
        while (b != 0) {
            // 这里是在判断m的二进制的最后一位是否为1
            if ((b & 1) == 1) {
                res = res * base;
            }
            base = base * base;
            // 向右移动1位
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        quick(3, 10);
    }
}

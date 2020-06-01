package jindian4;

public class convertInteger {

    // 整数转换,计算两个二进制整数不同的位数
    public static int convertInteger(int A, int B) {
        // 计算A、B不同的二进制位数，就计算A和B的异或，然后统计1的个数
        int x = A ^ B;
        int res = 0;
        while (x != 0) {
            x = x & (x - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        convertInteger(826966453, -729934991);
    }
}

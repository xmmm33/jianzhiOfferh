package jindian4;

public class reverseBits {

    // 把一个二进制整数中的0变成1之后，求连续1的个数的最大值
    public int reverseBits(int num) {
        int res = 0;
        // 记录当前连续1的个数
        int cur = 0;
        // 记录上一次连续1的个数
        int pre = 0;
        while (num != 0) {
            int bit = num & 1;
            if (bit > 0) {
                cur++;
            }else {
                pre = cur;
                cur = 0;
            }
            num = num >> 1;
            res = Math.max(res, cur + pre);
        }
        return res + 1;
    }
}

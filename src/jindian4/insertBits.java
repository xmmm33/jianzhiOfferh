package jindian4;

public class insertBits {

    // 插入
    public int insertBits(int N, int M, int i, int j) {
        int res = 0;
        int bit = 0;
        // 将M左移i位
        M = M << i;
        for (int k = 0; k < 32; k++) {
            // 1 << k的意思是 1左移k位 比如 1 << 3 结果为 1000
            // 那么 M & (1 << 3)的意思就是取M中的第三位的意思
            bit = (k >= i && k <= j) ? M & (1 << k) : N & (1 << k);
            res = res + bit;
        }
        return res;
    }
}

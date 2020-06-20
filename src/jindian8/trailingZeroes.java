package jindian8;

public class trailingZeroes {


    // 计算尾数有多少个0
    public static int trailingZeroes(int n) {
        /**
         * 0 是由 *10 得到的，而 10 是由 2 * 5 得到的
         * 因此我们求 n！ 过程中存在多少个 2 * 5
         * 因为 2 的个数必定比 5 的个数多，因此我们只求 5 的个数
         */
        int res = 0;
        while (n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
}

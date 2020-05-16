package jianzhiOffer4;

/**
 * 1到n中 1出现的次数
 */
public class countDigitOne {

    /**
     * 暴力超时
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i <=n ; i++) {
            int cnt = 0;
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 1) {
                    cnt++;
                }
                temp = temp / 10;
            }
            res += cnt;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        countDigitOne2(824883294);
    }

    /**
     * 思路：
     * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * @param n
     * @return
     */
    public static int countDigitOne2(int n) {
        if (n < 1) {
            return 0;
        }
        int res = 0;
        // 个位
        int dig = 1;
        // 高位
        int high = n/10;
        // 当前位
        int cur = n%10;
        // 低位
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res = res + high * dig;
            } else if (cur == 1) {
                res = res + high * dig + low + 1;
            }else {
                res = res + high * dig + dig;
            }
            low = low + cur * dig;
            cur = high % 10;
            high = high / 10;
            dig *= 10;
        }
        return res;
    }
}

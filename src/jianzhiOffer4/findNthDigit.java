package jianzhiOffer4;

/**
 *  数字序列中的某一位的数字
 */
public class findNthDigit {

    /**
     * 思路：
     * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long start = 1;
        int dig = 1;
        long numberscount = 9;
        while (n > numberscount) {
            n -= numberscount;
            start = start * 10;
            dig++;
            numberscount = start * dig * 9;
        }
        // 求n所在哪个数字中
        long num = start + (n - 1) / dig;
        // 求b所在这个数字的哪一位上
        return Long.toString(num).charAt((n - 1) % dig) - '0';
    }
}

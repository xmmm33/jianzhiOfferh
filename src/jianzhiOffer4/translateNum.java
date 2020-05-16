package jianzhiOffer4;

/**
 * 把数字翻译成字符串
 */
public class translateNum {

    /**
     * 思路：动态规划
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
     * 若xi和xi-1组成的数字可以被翻译，也就是在10到25范围之内的两位数，则fi = fi-2 + fi-1；否则fi = fi-1
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String temp = s.substring(i - 2, i);
            int c = Integer.parseInt(temp) <= 25 && Integer.parseInt(temp) >= 10 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}

package jianzhiOffer7;


/**
 * 不用加减乘除实现两个数的求和
 */
public class add {

    /**
     * 思路：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            // 进位
            int c = (a & b) << 1;
            // a等于非进位和
            a = a ^ b;
            // 让b等于进位c
            b = c;
        }
        return a;
    }
}

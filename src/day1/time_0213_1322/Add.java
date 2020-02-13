package day1.time_0213_1322;


/**
 * 不用加减乘除做加法
 * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * 思路：还是按位操作
 */
public class Add {

    /**
     * 比如 6 + 17
     * 6:   110
     * 17:10001
     * 23:10111
     * 思路:先异或，再与操作计算进位，知道异或计算结果为0退出循环
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int result, ans;
        do {
            // 每一位相加
            result = num1 ^ num2;
            // 进位
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
}

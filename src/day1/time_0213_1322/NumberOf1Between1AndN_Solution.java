package day1.time_0213_1322;

/**
 * 整数中1出现的次数 从1到n中的所有整数中，1出现了多少次
 */
public class NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int ret = 0;
        for (int i = 1; i <=n ; i++) {
            int count = 0;
            int a = i;
            while (a > 0) {
                int temp = a%10;
                if (temp == 1) {
                    count++;
                }
                a = a/10;
            }
            ret = ret + count;
        }
        return  ret;
    }

    public int NumberOf1Between1AndN_SolutionTwo(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        char[] chars = sb.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }
        }
        return count;
    }
}

package jianzhiOffer7;


/**
 * 把字符串转换为整数
 */
public class strToInt {

    public static int strToInt(String str) {
        long res = 0;
        boolean zheng = true;
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int i = 0;
        // 判断首字符是否合法
        if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {

            } else {
                return 0;
            }
        }
        // 判断正负
        if (str.charAt(0) == '+') {
            zheng = true;
            i++;
        }
        if (str.charAt(0) == '-') {
            zheng = false;
            i++;
        }
        // 计算整数
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            if (zheng && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!zheng && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (zheng ? res : -res);
    }

    public static void main(String[] args) {
        strToInt("42");
    }
}

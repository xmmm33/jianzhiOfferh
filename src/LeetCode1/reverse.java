package LeetCode1;

import java.util.Arrays;

public class reverse {

    /**
     * 反转整数
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String xs = String.valueOf(x);
        char[] xsc = xs.toCharArray();
        if (xsc.length == 1) {
            return x;
        }
        int left = 0;
        int right = xsc.length - 1;
        if (xsc[right] == '0') {
            xsc = Arrays.copyOf(xsc,xsc.length-1);
            right--;
        }
        if (xsc[left] == '-') {
            left++;
        }
        while (left < right) {
            char temp = xsc[left];
            xsc[left] = xsc[right];
            xsc[right] = temp;
            left++;
            right--;
        }
        long res = Long.parseLong(String.valueOf(xsc));
        if (res < Math.pow(-2, 31) || res > Math.pow(2, 31) - 1) {
            return 0;
        }else{
            return (int) res;
        }
    }

    /**
     * 字符串转整数
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str.length() < 1) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        long res = 0;
        int falg = 1;
        int cnt= 0;
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && a == 0 && cnt == 0) {
                continue;
            }
            if (str.charAt(i) == '-' && a==0) {
                falg=-1;
                cnt++;
                continue;
            }
            if (str.charAt(i) == '+' && a==0) {
                falg=1;
                cnt++;
                continue;
            }
            if (cnt == 2) {
                return 0;
            }
            if (res != 0 && (str.charAt(i) > '9' || str.charAt(i) < '0')) {
                return (int)res;
            }
            if (res == 0 && (str.charAt(i) > '9' || str.charAt(i) < '0')) {
                return 0;
            }
            res = res * 10 + falg * Integer.parseInt(String.valueOf(str.charAt(i)));
            if (res > Integer.MAX_VALUE ) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            a++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
    }
}

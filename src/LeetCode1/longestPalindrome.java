package LeetCode1;

/**
 * 最长回文子串
 * 首先把字符串反转，
 * 然后就是找原字符串和反转字符串的最大公共字串
 */
public class longestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abac"));
    }
    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int length = s.length();
        String reversal = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[length][length];
        int maxlen = 0;
        int maxend = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reversal.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                if (dp[i][j] > maxlen) {
                    int beforeindex = length-1-j;
                    if (beforeindex + dp[i][j] - 1 == i) {
                        maxlen = dp[i][j];
                        maxend = i;
                    }
                }
            }
        }
        return s.substring(maxend - maxlen + 1, maxend + 1);
    }
}

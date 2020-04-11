package LeetCode4;

public class countSubstrings {


    /**
     * 暴力法
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                int left = 0;
                int right = temp.length() - 1;
                boolean flag = true;
                while (left < right) {
                    if (temp.charAt(left) == temp.charAt(right)) {
                        left++;
                        right--;
                    }else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public static int countSubstrings3(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int cnt =0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                cnt++;
                left++;
                right--;
            }
        }
        return cnt;
    }


        public static void main(String[] args) {
        countSubstrings2("abc");
    }
}

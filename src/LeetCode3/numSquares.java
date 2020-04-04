package LeetCode3;

public class numSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 每次都将当前数字先更新为最大的结果，即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

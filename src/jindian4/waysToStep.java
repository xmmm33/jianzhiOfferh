package jindian4;

public class waysToStep {

    // 三步问题
    public static int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + ((dp[i - 2] + dp[i - 3]) % 1000000007)) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        waysToStep(5);
    }
}

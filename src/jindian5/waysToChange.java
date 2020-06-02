package jindian5;

import java.util.Arrays;

public class waysToChange {

    // 这是求一个数字n，可以有多少种组成情况
    public static int waysToChange3(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        // 初始化所有至少有由1组成的情况
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <coins.length ; j++) {
                if (i >= coins[j]) {
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }
        return dp[n];
    }

    // 求以最少的硬币个数组成目标值
    public int waysToChange2(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[n];
    }
}

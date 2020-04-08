package LeetCode4;

import java.util.Arrays;

public class coinChange {


    private int min = Integer.MAX_VALUE;

    //纯递归 超时
    public int coinChange(int[] coins, int amount) {
        if (coins.length < 1) {
            return -1;
        }
        findnumdfs(coins,amount,0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }else {
            return min;
        }
    }

    private void findnumdfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            min = Math.min(min, count);
        }
        for (int i = 0; i < coins.length; i++) {
            findnumdfs(coins, amount - coins[i], count + 1);
        }
    }

    //==========================TODO=============================
    // 自上而下的记忆动态规划
    public static int coinChange2(int[] coins, int amount) {
        if (coins.length < 1) {
            return -1;
        }
        int[] dp = new int[amount];
        return dfs(coins, amount, dp);
    }

    private static int dfs(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount - 1] != 0) {
            return dp[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        // dp中的i表示i+1元的硬币最少需要多少个硬币组成
        for (int i = 0; i < coins.length; i++) {
            int tmpres = dfs(coins, amount - coins[i], dp);
            if (tmpres >= 0 && tmpres < min) {
                min = tmpres + 1;
            }
        }
        dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount - 1];
    }

    //==========================TODO=============================

    /**
     * F(i)	最小硬币数量
     * F(0)	0 //金额为0不能由硬币组成
     * F(1)	1 //F(1)=min(F(1-1),F(1-2),F(1-5))+1=1F(1)=min(F(1−1),F(1−2),F(1−5))+1=1
     * F(2)	1 //F(2)=min(F(2-1),F(2-2),F(2-5))+1=1F(2)=min(F(2−1),F(2−2),F(2−5))+1=1
     * F(3)	2 //F(3)=min(F(3-1),F(3-2),F(3-5))+1=2F(3)=min(F(3−1),F(3−2),F(3−5))+1=2
     * F(4)	2 //F(4)=min(F(4-1),F(4-2),F(4-5))+1=2F(4)=min(F(4−1),F(4−2),F(4−5))+1=2
     * ...	...
     * F(11) 3 //F(11)=min(F(11-1),F(11-2),F(11-5))+1=3F(11)=min(F(11−1),F(11−2),F(11−5))+1=3
     * 这是自下向上的动态规划，类似于01背包问题
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        if (coins.length < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChange3(new int[]{1, 2, 5}, 11);
    }
}

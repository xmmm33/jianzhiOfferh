package LeetCode4;

import java.util.Arrays;

public class coinChange {

    /**
     * F(i)	最小硬币数量
     * F(0)	0 //金额为0不能由硬币组成
     * F(1)	1 //F(1)=min(F(1−1),F(1−2),F(1−5))+1=1
     * F(2)	1 //F(2)=min(F(2-1),F(2-2),F(2-5))+1=1
     * F(3)	2 //F(3)=min(F(3-1),F(3-2),F(3-5))+1=2
     * F(4)	2 //F(4)=min(F(4-1),F(4-2),F(4-5))+1=2
     * ...	...
     * F(11) 3 //F(11)=min(F(11-1),F(11-2),F(11-5))+1=3
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
        for (int i = 1; i <= amount; i++) {
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

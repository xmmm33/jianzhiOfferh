package jianzhiOffer6;

/**
 * n个筛子的和
 */
public class sumofshaizi {

    public double[] twoSum(int n) {
        //dp[i][j]代表i枚色子和为j的概率
        double[][] dp=new double[n+1][6*n+1];
        double probability=1.0/6.0;
        // 初始化只有一枚筛子的时候的概率
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = probability;
        }
        // 枚举筛子
        for (int i = 2; i <= n; i++) {
            // 枚举点数
            for (int j = i; j <= i*6 ; j++) {
                // 枚举当前筛子的点数
                for (int k = 1; k <= j && k <= 6; k++) {
                    dp[i][j] = dp[i][j] + (probability * dp[i - 1][j - k]);
                }
            }
        }
        double[] res = new double[5 * n + 1];
        System.arraycopy(dp[n], n, res, 0, res.length);
        return res;
    }
}

package LeetCode3;

public class maximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}

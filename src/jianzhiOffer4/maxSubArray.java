package jianzhiOffer4;

/**
 * 连续子数组最大和
 */
public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Math.max(Integer.MIN_VALUE, dp[0]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}

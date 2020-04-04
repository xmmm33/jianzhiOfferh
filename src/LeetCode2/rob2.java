package LeetCode2;

import java.util.Arrays;

public class rob2 {

    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            // 取前一天能盗取的值 和 前两天加上今天盗取的值 比较取较大的值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int rob2(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        dp1[0] = nums1[0];
        dp2[0] = nums2[0];
        dp1[1] = Math.max(nums1[0], nums1[1]);
        dp2[1] = Math.max(nums2[0], nums2[1]);
        int max1 = dp1[1];
        int max2 = dp2[1];
        for (int i = 2; i < nums1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums1[i]);
            max1 = Math.max(max1, dp1[i]);
        }
        for (int i = 2; i < nums2.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums2[i]);
            max2 = Math.max(max2, dp2[i]);
        }
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        rob2(new int[]{2, 3, 2});
    }
}

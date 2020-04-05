package LeetCode3;

public class lengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <nums.length ; i++) {
            int cnt = 0;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i <nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

package LeetCode3;

public class increasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i <nums.length ; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt + 1;
            max = Math.max(max, dp[i]);
            if (max >= 3) {
                return true;
            }
        }
        return false;
    }
}

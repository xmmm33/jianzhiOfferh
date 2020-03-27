package leetcode;

public class canJump {

    /**
     * 倒着推
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        int end = nums.length - 1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }

    /**
     * 正着推
     */
    public boolean jump(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length && j <= i + nums[i]; j++) {
                dp[j] = true;
            }
        }
        if (dp[nums.length - 1]) {
            return true;
        }else {
            return false;
        }
    }
}

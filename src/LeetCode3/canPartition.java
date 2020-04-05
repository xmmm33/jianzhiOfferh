package LeetCode3;

public class canPartition {

    /**
     * 就是01背包问题
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int taget = sum / 2;
        boolean[] dp = new boolean[taget+1];
        dp[0] = true;
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            for (int j = taget; j >= num; j--) {
                // 假如dp[i - num]为true，则表示在num之前的数组可以找出和为i - num的集合，那么再加入了num之后，数组也能找出和为i的集合，于是dp[i]更新为true。
                if (dp[j - num] == true) {
                    dp[j] = true;
                }
            }
        }
        return dp[taget];
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k == 1) {
            return false;
        }
        int cnt = 0;
        int target = sum / k;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                // 假如dp[i - num]为true，则表示在num之前的数组可以找出和为i - num的集合，那么再加入了num之后，数组也能找出和为i的集合，于是dp[i]更新为true。
                if (dp[j - num] == true) {
                    if (j == target) {
                        cnt++;
                    }
                    dp[j] = true;
                }
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        canPartitionKSubsets(new int[]{7,2,2,2,2,2,2,2,3}, 3);
    }
}

package LeetCode4;

public class findTargetSumWays {

    private int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length < 1) {
            return 0;
        }
        dfs(nums, 0, S, 0);
        return cnt;
    }

    private void dfs(int[] nums, int index, int sum, int cursum) {
        if (index == nums.length) {
            if (sum == cursum) {
                cnt++;
            }
        } else {
            dfs(nums, index + 1, sum, cursum + nums[index]);
            dfs(nums, index + 1, sum, cursum - nums[index]);
        }
    }
}

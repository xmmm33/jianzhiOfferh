package LeetCode2;

public class checkSubarraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (k == 0 && sum == 0) {
                    return true;
                }
                if (k == 0) {
                    continue;
                }
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

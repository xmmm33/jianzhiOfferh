package LeetCode4;

public class subarraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}

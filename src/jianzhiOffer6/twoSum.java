package jianzhiOffer6;

/**
 * 两个数字的和
 */
public class twoSum {

    /**
     * 二分的思想
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[2];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            }else {
                return new int[]{nums[low], nums[high]};
            }
        }
        return new int[0];
    }
}

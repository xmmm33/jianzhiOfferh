package leetcode.tanxin;

/**
 * 子数组最大和
 */
public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            // 比较当前元素的值 和 加到当前元素的和的值大小关系；从而每次得到最大值，更新max，最后得到最大值
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}

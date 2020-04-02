package LeetCode2;

public class maxProduct {

    public int maxProduct(int[] nums) {
        // 由于存在负数，所以需要维护两个数组
        // dp_max[i] 指的是以第 i 个数结尾的 乘积最大 的连续子序列
        // dp_min[i] 指的是以第 i 个数结尾的 乘积最小 的连续子序列
        int[] maxdp = new int[nums.length + 1];
        int[] mindp = new int[nums.length + 1];
        if (nums.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        maxdp[0] = 1;
        mindp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            // 如果数组的数是负数，那么会导致 max 变成 min，min 变成 max
            // 故需要交换dp
            if (nums[i - 1] < 0) {
                int temp = mindp[i - 1];
                mindp[i - 1] = maxdp[i - 1];
                maxdp[i - 1] = temp;
            }
            mindp[i] = Math.min(nums[i - 1], mindp[i - 1] * nums[i - 1]);
            maxdp[i] = Math.max(nums[i - 1], maxdp[i - 1] * nums[i - 1]);
            max = Math.max(max, maxdp[i]);
        }
        return max;
    }
}

package leetcode;

public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));;
    }
}

package LeetCode3;

public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length < 1) {
            return res;
        }
        int k = 1;
        // 左边乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        // 右边乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * k;
            k = k * nums[i];
        }
        return res;
    }
}

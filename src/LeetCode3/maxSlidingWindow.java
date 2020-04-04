package LeetCode3;

public class maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums.length < 1) {
            return res;
        }
        for (int i = 0; i < nums.length - k+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}

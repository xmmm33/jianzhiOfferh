package jianzhiOffer6;


/**
 * 滑动窗口的最大值
 */
public class maxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }
        if (k < 1) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        int a = 0;
        int low = 0;
        int high = k-1;
        while (low <= high && high < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                max = Math.max(max, nums[i]);
            }
            res[a++] = max;
            low++;
            high++;
        }
        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1}, 1);
    }
}

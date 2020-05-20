package jianzhiOffer5;

/**
 * 在排序数组中查找数字
 */
public class search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }


    /**
     * 二分法的思路
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        // 二分查找最右左边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        while (left < nums.length && nums[left++] == target) {
            res++;
        }
        return res;
    }
}

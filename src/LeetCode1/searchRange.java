package LeetCode1;

public class searchRange {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length < 1) {
            return res;
        }
        int low = 0;
        int right = nums.length - 1;
        while (res[0] == -1 || res[1]==-1) {
            if (target > nums[low]) {
                low++;
            } else if (target < nums[low]) {
                return res;
            }else {
                res[0] = low;
            }
            if (target < nums[right]) {
                right--;
            } else if (target > nums[right]) {
                return res;
            } else {
                res[1] = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}

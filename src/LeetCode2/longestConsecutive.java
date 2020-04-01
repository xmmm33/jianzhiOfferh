package LeetCode2;

import java.util.Arrays;

public class longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        int max = 1;
        int res = 1;
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 1;
        Arrays.sort(nums);
        while (left < nums.length) {
            if (nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (nums[left] - nums[left - 1] == 1) {
                left++;
                max = max +1;
                res = Math.max(max, res);
            }else {
                left++;
                max = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3}));
    }
}

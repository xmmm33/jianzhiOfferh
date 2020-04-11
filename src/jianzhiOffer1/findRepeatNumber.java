package jianzhiOffer1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (res.contains(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }
}

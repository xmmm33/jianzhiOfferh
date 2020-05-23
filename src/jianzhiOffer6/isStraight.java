package jianzhiOffer6;

import java.util.HashSet;
import java.util.Set;

public class isStraight {

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Set<Integer> temp = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (temp.contains(nums[i])) {
                return false;
            }
            temp.add(nums[i]);
        }
        return max - min < 5;
    }
}

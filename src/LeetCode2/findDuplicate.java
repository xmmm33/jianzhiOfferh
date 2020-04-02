package LeetCode2;

import java.util.HashSet;
import java.util.Set;

public class findDuplicate {

    public int findDuplicate(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (temp.contains(nums[i])) {
                return nums[i];
            }
            temp.add(nums[i]);
        }
        return 0;
    }
}

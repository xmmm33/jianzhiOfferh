package LeetCode2;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int level = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > level) {
                return key;
            }
        }
        return -1;
    }
}

package jianzhiOffer3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int base = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > base) {
                return key;
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int base = nums.length / 2;
        Arrays.sort(nums);
        int cnt = 1;
        int f = nums[0];
        for (int i = 1; i <nums.length; i++) {
            if (f == nums[i]) {
                cnt++;
                if (cnt >= base) {
                    return f;
                }
            }else {
                f = nums[i];
                cnt = 1;
            }
        }
        return -1;
    }
}

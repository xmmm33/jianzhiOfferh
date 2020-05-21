package jianzhiOffer6;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中数字出现的次数II，数组中只有一个数字出现了一次，其他的数字都出现了三次
 */
public class singleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            temp.put(num, temp.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : temp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

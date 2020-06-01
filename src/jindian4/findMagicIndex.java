package jindian4;

import java.util.Arrays;

public class findMagicIndex {

    // 魔术索引
    public int findMagicIndex(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public int findMagicIndex2(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return res;
        }
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前的元素都大于0了，因为这是一个升序数组，所以后面的元素不可能相加等于0了
            if (nums[i] > 0) {
                break;
            }
            // 去重，当数组等于前一个元素的时候，说明计算过了，防止重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i+1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 也是去重
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    // 说明值小于0，还需要加大的
                    L++;
                } else if (sum > 0){
                    // 说明值大于0，还需要加小的
                    R--;
                }
            }
        }
        return res;
    }

    public static int sum(int[] nums, int taeget) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int mid = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(taeget - nums[i] - nums[j] - nums[k]) < min) {
                        min = Math.abs(taeget - nums[i] - nums[j] - nums[k]);
                        l = i;
                        mid = j;
                        r = k;
                    }
                }
            }
        }
        return nums[l] + nums[mid] + nums[r];
    }

    /**
     * 四数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 1) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <len ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i+1; j <len ; j++) {
                int L = j+1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i] + nums[j] + nums[L] + nums[R]));
                        while (L < R && nums[L] == nums[L+1]) L++;
                        while (L < R && nums[R] == nums[R-1]) R--;
                        L++;
                        R--;
                    } else if (sum > target) {
                        R--;
                    } else if (sum < target) {
                        L++;
                    }
                }
            }
        }
        return res;
    }
}

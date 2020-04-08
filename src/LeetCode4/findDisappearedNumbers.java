package LeetCode4;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {

    /**
     * 使用了辅助空间
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] temp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = 1;
        }
        for (int i = 1; i <temp.length ; i++) {
            if (temp[i] != 1) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 不使用额外空间
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 因为数组里面的元素满足 nums[i] <= nums.length
        // 所以可以遍历当前数组，如果遍历的数字为3，那么把nums[2]变为负数，说明数字3是出现过的；最后在遍历一次数组，如果大于0的数组位置就说明不存在这个数字
        for (int i = 0; i <nums.length ; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}

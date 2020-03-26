package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {

    /**
     * 全排列2
     * 数组中有重复的元素
     * 这种必须先排序，才能判断这个元素是否使用过
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        // 切记排序!!!!!!!
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        dfs(nums, res, new ArrayList<Integer>(),flag);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> path, boolean[] flag) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            // 判断上一个元素和这一个元素是否相等，且上一个元素是否被使用过
            if (i > 0 && nums[i - 1] == nums[i] && !flag[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            flag[i] = true;
            dfs(nums, res, path, flag);
            path.remove(path.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        permuteUnique(new int[]{1, 1, 2});
    }
}

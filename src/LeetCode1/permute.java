package LeetCode1;

import java.util.ArrayList;
import java.util.List;

public class permute {

    /**
     * 全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        dfs(nums, res, new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 防止一个元素被重复使用
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }
}

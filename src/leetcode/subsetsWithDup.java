package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length+1; i++) {
            dfs(0, nums, new ArrayList<Integer>(), res, i);
        }
        return res;
    }

    private static void dfs(int pos, int[] nums, ArrayList<Integer> path, List<List<Integer>> res, int cursize) {
        if (path.size() == cursize) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(i + 1, nums, path, res, cursize);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsetsWithDup(new int[]{1, 2, 2});
    }
}

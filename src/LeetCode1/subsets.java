package LeetCode1;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    /**
     * 子集
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            dfs(0, new ArrayList<Integer>(), nums, i,res);
        }
        return res;
    }

    private static void dfs(int index, ArrayList<Integer> integers, int[] nums, int cursize, List<List<Integer>> res) {
        if (integers.size() == cursize) {
            res.add(new ArrayList<>(integers));
        }
        for (int i = index; i <nums.length ; i++) {
            integers.add(nums[i]);
            dfs(i + 1, integers, nums, cursize, res);
            integers.remove(integers.size() - 1);
        }
    }


    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }
}

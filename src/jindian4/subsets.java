package jindian4;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    private static List<List<Integer>> res = new ArrayList<>();
    // 一个集合的所有子集 字符的全排列问题
    public static List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0, new ArrayList<Integer>());
        res.add(new ArrayList<>());
        return res;
    }

    private static void backtrace(int[] nums, int pos, ArrayList<Integer> subsets) {
        if (!subsets.isEmpty()) {
            res.add(new ArrayList<>(subsets));
        }
        for (int i = pos; i < nums.length; i++) {
            subsets.add(nums[i]);
            backtrace(nums, i + 1, subsets);
            subsets.remove(subsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{0});
    }
}

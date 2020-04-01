package LeetCode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(0, 0, target, candidates, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int sum, int index, int target, int[] candidates, ArrayList<Integer> path, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 这个if是去重的
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            int tempsum = sum + candidates[i];
            dfs(tempsum, i + 1, target, candidates, path, res);
            path.remove(path.size() - 1);
        }
    }
}

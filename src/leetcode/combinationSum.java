package leetcode;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        dfs(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int sum, int pos, int target, int[] candidates, ArrayList<Integer> path,
                        List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(sum + candidates[i], i, target, candidates, path, res);
            path.remove(path.size() - 1);
        }
    }
}

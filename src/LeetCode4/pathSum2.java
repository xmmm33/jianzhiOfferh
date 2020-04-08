package LeetCode4;

import java.util.ArrayList;
import java.util.List;

public class pathSum2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root,res, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int sum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,res, sum, path);
        dfs(root.right, res, sum, path);
        // 回溯
        path.remove(path.size() - 1);
    }
}

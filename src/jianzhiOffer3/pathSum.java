package jianzhiOffer3;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为某一个值的路径
 */
public class pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        track(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void track(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        track(root.left, sum, path);
        track(root.right, sum, path);
        path.remove(path.size() - 1);
        return;
    }
}

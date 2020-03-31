package leetcode;

import java.util.ArrayList;
import java.util.List;

public class minDiffInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int min = Integer.MAX_VALUE;
    List<Integer> temp = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        pre(root);
        for (int i = 1; i < temp.size(); i++) {
            min = Math.min(min, temp.get(i) - temp.get(i - 1));
        }
        return min;
    }

    private void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        pre(root.left);
        temp.add(root.val);
        pre(root.right);
    }
}

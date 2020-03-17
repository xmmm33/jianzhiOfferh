package leetcode.fenzhi;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出所有可能组成的二叉树
 */
public class generateTrees {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static List<TreeNode> genTree(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return gentrees(1, n);
    }

    private static List<TreeNode> gentrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefttrees = gentrees(start, i - 1);
            List<TreeNode> righttrees = gentrees(i + 1, end);
            for (TreeNode left : lefttrees) {
                for (TreeNode right : righttrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] a) {
        genTree(3);
    }
}

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层次遍历判断对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null) {
                return false;
            }
            if (n1.val != n2.val) {
                return false;
            }
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

    /**
     * 递归遍历对称二叉树
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMinor(root.left, root.right);
    }

    private boolean isMinor(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMinor(left.left, right.right) && isMinor(left.right, right.left);
    }
}

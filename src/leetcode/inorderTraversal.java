package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        in(root, res);
        return res;
    }

    private void in(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        in(root.left, res);
        res.add(root.val);
        in(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }
}

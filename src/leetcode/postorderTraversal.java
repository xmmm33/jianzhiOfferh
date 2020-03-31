package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        last(root);
        return res;
    }

    private void last(TreeNode root) {
        if (root == null) {
            return;
        }
        last(root.left);
        last(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            root = node.right;
            if (node.right == null) {
                res.add(node.val);
                stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}

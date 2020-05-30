package jindian3;

public class isBalanced {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 检查一个二叉树的平衡性
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(helper(root.left) - helper(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(helper(root.left),helper(root.right)) + 1;
    }
}

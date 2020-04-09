package LeetCode4;

public class convertBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int share = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        rightToleft(root);
        return root;
    }

    private void rightToleft(TreeNode root) {
        if (root == null) {
            return;
        }
        rightToleft(root.right);
        root.val = root.val + share;
        share = root.val;
        rightToleft(root.left);
    }
}

package jianzhiOffer2;

public class isSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return is(root, root);
    }

    private boolean is(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }else {
                return is(left.left, right.right) && is(left.right, right.left);
            }
        }
        return false;
    }

}

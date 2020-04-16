package jianzhiOffer2;

public class isSubStructure {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (!ispartsame(A, B)) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return true;
    }

    private boolean ispartsame(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            return ispartsame(a.left, b.left) && ispartsame(a.right, b.right);
        }else {
            return false;
        }
    }


}

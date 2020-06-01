package jindian4;

public class checkSubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 检查子树，判断一个二叉树是否是另一个二叉树的子树
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
}

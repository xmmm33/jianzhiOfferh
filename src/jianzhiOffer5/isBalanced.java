package jianzhiOffer5;

/**
 * 判断是不是平衡二叉树
 */
public class isBalanced {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先计算左右子树的高度
        int left = maxd(root.left);
        int right = maxd(root.right);
        // 判断是否为平衡二叉树
        if (Math.abs(left - right) > 1) {
            return false;
        }else {
            // 继续判断左子树的左右子树的高度是否满足平衡二叉树 和 右子树的左右子树的高度是否满足平衡二叉树
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int maxd(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxd(root.left),maxd(root.right)) + 1;
    }
}

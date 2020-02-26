package day2.time_0226_0945;

/**
 * 树的子结构
 * 输入两棵树A、B，判断B是不是A的子结构
 */
public class HasSubtree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 比较左边是否有子结构  比较右边是否有子结构
        return judgeSubTree(root1, root2) ||
                judgeSubTree(root1.left, root2) ||
                judgeSubTree(root1.right, root2);
    }

    private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return judgeSubTree(root1.left, root2.left) &&
                    judgeSubTree(root1.right, root2.right);
        }
        return judgeSubTree(root1.left, root2) ||
                judgeSubTree(root1.right, root2);
    }

    public static void main(String[] args) {

    }
}

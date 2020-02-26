package day2.time_0226_0945;

/**
 * 树的镜像
 *           8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class MirrorTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        TreeNode tempright = root.right;
        root.left = root.right;
        root.right = temp;
        Mirror(temp);
        Mirror(tempright);
    }

    public static void main(String[] args) {

    }
}

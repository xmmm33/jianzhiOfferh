package LeetCode2;

public class flatten {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            }else {
                TreeNode pre = root.left;
                // 找左子树的最右节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来的右子树接到左子树的最右节点
                pre.right = root.right;
                // 将根节点的左子树放到右子树的位置
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}

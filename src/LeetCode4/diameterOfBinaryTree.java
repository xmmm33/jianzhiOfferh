package LeetCode4;

public class diameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int pathlength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return pathlength;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 取每个节点的最大直径，就是除去根节点的节点个数值
        pathlength = Math.max(pathlength, left + right);
        // 返回节点深度
        return Math.max(left, right) + 1;
    }

}

package LeetCode4;

public class hasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}

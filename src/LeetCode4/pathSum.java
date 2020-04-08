package LeetCode4;

public class pathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 双重递归
     * 每一个节点都需要来一遍pathSum的过程
     */
    private int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        qianxu(root, sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return cnt;
    }

    private void qianxu(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        if (sum == 0) {
            cnt++;
        }
        qianxu(root.left,sum);
        qianxu(root.right,sum);
    }
}

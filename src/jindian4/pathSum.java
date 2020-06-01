package jindian4;

import java.util.ArrayList;
import java.util.List;

public class pathSum {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> paht = new ArrayList<>();

    // 二叉树路径和为唯一值的路径
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum,new ArrayList<>());
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return paht.size();
    }

    private void dfs(TreeNode root, int sum, ArrayList<Integer> p) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        p.add(root.val);
        if (sum == 0) {
            paht.add(new ArrayList<>(p));
        }
        dfs(root.left, sum, p);
        dfs(root.right, sum, p);
        p.remove(p.size() - 1);
    }

}

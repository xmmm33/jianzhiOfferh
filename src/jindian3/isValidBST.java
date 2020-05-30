package jindian3;

import java.util.ArrayList;
import java.util.List;

public class isValidBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> path = new ArrayList<>();
    // 判断一个二叉树是不是合法的二叉树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        zhongxu(root);
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i) >= path.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void zhongxu(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongxu(root.left);
        path.add(root.val);
        zhongxu(root.right);
    }


    private TreeNode pre = null;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre == null) {
            pre = root;
        }else {
            if (pre.val >= root.val) {
                return false;
            }
        }
        pre = root;
        if (isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}

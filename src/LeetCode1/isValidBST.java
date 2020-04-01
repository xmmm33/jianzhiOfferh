package LeetCode1;

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

    /**
     * 判断是否为二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if (res.size() == 1) {
            return true;
        }
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) < res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

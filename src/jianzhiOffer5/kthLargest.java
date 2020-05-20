package jianzhiOffer5;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第k大的节点
 */
public class kthLargest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> temp = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        zhongxubianli(root);
        return temp.get(temp.size() - k);
    }

    private void zhongxubianli(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongxubianli(root.left);
        temp.add(root.val);
        zhongxubianli(root.right);
    }
}

package day2.time_0229_1225;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 * 注意：二叉搜索树的中序遍历是升序
 */
public class KthNode {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        zhongxu(pRoot);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    private void zhongxu(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        zhongxu(pRoot.left);
        list.add(pRoot);
        zhongxu(pRoot.right);
    }
}

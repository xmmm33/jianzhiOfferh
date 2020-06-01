package jindian4;

import java.util.ArrayList;
import java.util.List;

public class inorderSuccessor {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> temp = new ArrayList<>();
    // 找出二叉搜索树的后继节点
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        zhongxu(root, p);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).val == p.val) {
                return i + 1 >= temp.size() ? null : temp.get(i + 1);
            }
        }
        return null;
    }

    private void zhongxu(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        zhongxu(root.left, p);
        temp.add(root);
        zhongxu(root.right, p);
    }
}

package day2.time_0226_0945;

/**
 * 把二叉搜索树转换为有序的双向链表
 * 不允许创建任何新的节点
 */
public class Convert {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode find(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode right = Convert(pRootOfTree.right);
        // 双向链表的头
        TreeNode head;
        // 找到左子树的最右子节点
        if (left != null) {
            head = left;
            left = find(left);
        }else {
            head = pRootOfTree;
        }

        // 把根节点的左指针 指向左子树的最右节点；然后把最右节点的左孩子指向当前节点
        pRootOfTree.left = left;
        if (left != null) {
            left.right = pRootOfTree;
        }
        // 把根节点的右指针 指向右子树的左节点也就是自己的右孩子节点；然后把右孩子的左指针指向当前节点
        pRootOfTree.right = right;
        if (right != null) {
            right.left = pRootOfTree;
        }
        return head;
    }
}

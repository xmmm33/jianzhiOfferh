package day2.time_0229_1225;

/**
 * 判断一个二叉树是否是对称的
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class isSymmetrical {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 就是说一个二叉树的父节点的两个子节点，parent.left.left = parent.right.right
     * 就是说一个节点的左孩子节点必须等于这个节点的兄弟节点的右孩子节点
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        boolean res = jude(pRoot.left, pRoot.right);
        return res;
    }

    private boolean jude(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }else if (left == null || right == null){
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 递归判断节点的左孩子是否等于兄弟节点的右孩子
        boolean ret1 = jude(left.left, right.right);
        // 递归判断节点的右孩子是否等于兄弟节点的左孩子
        boolean ret2 = jude(left.right, right.left);
        return ret1 & ret2;
    }
}


package day2.time_0224_1854;

import java.util.Stack;

public class ZhongxuTest {

    public static class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static TreeNode init() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t6.right = t8;
        return t1;
    }

    public static void zhongxudigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        zhongxudigui(treeNode.left);
        System.out.print(treeNode.val);
        zhongxudigui(treeNode.right);
    }

    /**
     * 先访问完左子树，所以先是一个while循环，顺着左子树走完之后
     * 再去访问根结点和右子树
     * @param treeNode
     */
    public static void zhongxuNondigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            // 一直遍历到左子树最下边，边遍历 边保存根节点到栈中
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 当treeNode为空时，说明已经到达左子树最下边，这时需要出栈了
            if (!stack.isEmpty()) {
                // 取出的是最左边的左节点
                TreeNode node = stack.pop();
                System.out.print(node.val);
                // 进入右子树，开始新的一轮左子树遍历(这是递归的自我实现)
                treeNode = node.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println("递归中序");
        zhongxudigui(root);
        System.out.println("\n非递归中序");
        zhongxuNondigui(root);
    }
}

package day2.time_0224_1854;

import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class Tree {

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


    /**
     * 深度优先有三种：先序、中序、后序
     * 递归实现先序遍历
     * @param treeNode
     */
    public static void xianxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        xianxu(treeNode.left);
        xianxu(treeNode.right);
    }

    /**
     * 递归实现中序遍历
     * @param treeNode
     */
    public static void zhongxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        zhongxu(treeNode.left);
        System.out.println(treeNode.val);
        zhongxu(treeNode.right);
    }

    /**
     * 递归实现后序遍历
     * @param treeNode
     */
    public static void houxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        houxu(treeNode.left);
        houxu(treeNode.right);
        System.out.println(treeNode.val);
    }

    /**
     * 非递归实现先序
     * 递归的实现一定可以转换为栈的结构
     * 先找到最左边的，当左边的left为null的时候，出栈一个node，即为上一个节点
     * 再根据这个节点的右节点作为一棵树，再次找到最左边的节点。重复这个过程。
     * @param treeNode
     */
    public static void xianxuNondigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode node = stack.pop();
            // 在这里打印的话就是中序遍历的结果
            // System.out.println(node.val);
            treeNode = node.right;
        }
    }

    /**
     * 非递归实现中序遍历
     * @param treeNode
     */
    public static void zhongxuNondigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val);
            treeNode = node.right;
        }
    }

    /**
     * 非递归实现后序遍历
     * @param treeNode
     */
    public static void houxuNondigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode node = stack.peek();
            treeNode = node.right;
            if (node.right == null) {
                System.out.print(node.val);
                stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                    System.out.print(node.val);
                }
            }
        }
    }

    /**
     * 广度优先遍历
     * @param treeNode
     */
    public static void guangdu(TreeNode treeNode) {

    }

    public static void main(String[] args) {
        TreeNode treeNode = init();
        System.out.println("先序：");
//        xianxu(treeNode);
        xianxuNondigui(treeNode);
        System.out.println("\n中序：");
//        zhongxu(treeNode);
        zhongxuNondigui(treeNode);
        System.out.println("\n后序：");
//        houxu(treeNode);
        houxuNondigui(treeNode);
    }
}

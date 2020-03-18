package day2.time_0224_1854;

import practice.tree.treeBianli;

import java.util.Stack;

public class HouxuTest {
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

    public static void houxudigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        houxudigui(treeNode.left);
        houxudigui(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
     * 若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
     * 若是位于右子树，则直接访问根节点。
     * @param treeNode
     */
    public static void houxuNondigui(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            // 遍历左子树
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 这里不能pop，因为要判断是否右孩子节点为空，不为空就不能先打印根节点
            TreeNode node = stack.peek();
            treeNode = node.right;
            // 判断node节点是否有右孩子节点，没有的话，直接访问node节点；如果有右孩子节点，需要先跳过，所以是stack.peek()；
            if (node.right == null) {
                System.out.print(node.val);
                node = stack.pop();
                // 这里需要去判断当前的node节点 是不是上一个节点的右孩子，如果是，弹出上一个节点，并打印，
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                    System.out.print(node.val);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = init();
        System.out.println("递归后序");
        houxudigui(treeNode);
        System.out.println("\n非递归后序");
        treeBianli.houxu(treeNode);
    }
}

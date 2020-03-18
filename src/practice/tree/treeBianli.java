package practice.tree;

import day2.time_0224_1854.HouxuTest;
import day2.time_0224_1854.XianxuTest;
import day2.time_0224_1854.ZhongxuTest;

import java.util.Stack;

public class treeBianli {

    public static void xianxu(XianxuTest.TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<XianxuTest.TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.getVal());
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                // 取出最左节点
                XianxuTest.TreeNode temp = stack.pop();
                root = temp.getRight();
            }
        }
    }

    public static void zhongxu(ZhongxuTest.TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<ZhongxuTest.TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                ZhongxuTest.TreeNode temp = stack.pop();
                System.out.println(temp.getVal());
                root = temp.getRight();
            }
        }
    }

    public static void houxu(HouxuTest.TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<HouxuTest.TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            HouxuTest.TreeNode temp = stack.peek();
            treeNode = temp.getRight();
            // 判断当前节点是否有右孩子 没有就可以直接打印
            if (temp.getRight() == null) {
                System.out.println(temp.getVal());
                temp = stack.pop();
                // 判断当前节点是不是上一个节点的右孩子节点
                while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                    temp = stack.pop();
                    System.out.println(temp.getVal());
                }
            }
        }
    }
}

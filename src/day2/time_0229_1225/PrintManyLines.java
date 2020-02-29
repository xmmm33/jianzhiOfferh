package day2.time_0229_1225;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintManyLines {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        list1.add(pRoot);
        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (!list1.isEmpty()) {
                ArrayList<Integer> ret = new ArrayList<>();
                while (!list1.isEmpty()) {
                    TreeNode node = list1.poll();
                    ret.add(node.val);
                    if (node.left != null) {
                        list2.add(node.left);
                    }
                    if (node.right != null) {
                        list2.add(node.right);
                    }
                }
                res.add(ret);
            }
            if (!list2.isEmpty()) {
                ArrayList<Integer> ret = new ArrayList<>();
                while (!list2.isEmpty()) {
                    TreeNode node = list2.poll();
                    ret.add(node.val);
                    if (node.left != null) {
                        list1.add(node.left);
                    }
                    if (node.right != null) {
                        list1.add(node.right);
                    }
                }
                res.add(ret);
            }
        }
        return res;
    }
}

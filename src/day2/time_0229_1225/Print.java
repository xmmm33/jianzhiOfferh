package day2.time_0229_1225;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Print {
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
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                ArrayList<Integer> ret = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode temp = stack1.pop();
                    ret.add(temp.val);
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                }
                res.add(ret);
            }
            if (!stack2.isEmpty()) {
                ArrayList<Integer> ret = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode temp = stack2.pop();
                    ret.add(temp.val);
                    if (temp.right != null) {
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                }
                res.add(ret);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> PrintTwo(TreeNode pRoot) {
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
                    TreeNode temp = list1.poll();
                    ret.add(temp.val);
                    if (temp.left != null) {
                        list2.add(0, temp.left);
                    }
                    if (temp.right != null) {
                        list2.add(0, temp.right);
                    }
                }
                res.add(ret);
            }
            if (!list2.isEmpty()) {
                ArrayList<Integer> ret = new ArrayList<>();
                while (!list2.isEmpty()) {
                    TreeNode temp = list2.poll();
                    ret.add(temp.val);
                    if (temp.right != null) {
                        list1.add(0, temp.right);
                    }
                    if (temp.left != null) {
                        list1.add(0, temp.left);
                    }
                }
                res.add(ret);
            }
        }
        return res;
    }
}
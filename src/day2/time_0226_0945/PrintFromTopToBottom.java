package day2.time_0226_0945;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下遍历二叉树
 * 也就是层次遍历
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 层次遍历返回结果
        ArrayList<Integer> ret = new ArrayList<>();
        // 保证先进先出
        List<TreeNode> temp = new LinkedList();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode tempnode = ((LinkedList<TreeNode>) temp).poll();
            ret.add(tempnode.val);
            if (tempnode.left != null) {
                temp.add(tempnode.left);
            }
            if (tempnode.right != null) {
                temp.add(tempnode.right);
            }
        }
        return ret;
    }

    /**
     * 从下往上层次遍历二叉树
     * @param root
     * @return
     */
    public ArrayList<List<Integer>> PrintFromBottomToTop(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<List<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> templist = new LinkedList<>();
        List<Integer> levelList = new ArrayList<>();
        templist.add(root);
        int levelSize = templist.size();
        while (!templist.isEmpty()) {
            if (levelSize == 0) {
                ret.add(0, levelList);
                levelSize = templist.size();
                levelList = new ArrayList<>();
            }
            TreeNode node = templist.poll();
            levelList.add(node.val);
            if (node.left != null) {
                templist.add(node.left);
            }
            if (node.right != null) {
                templist.add(node.right);
            }
        }
        ret.add(0, levelList);
        return ret;
    }
}

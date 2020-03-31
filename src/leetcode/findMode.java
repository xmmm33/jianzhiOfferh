package leetcode;

import java.util.ArrayList;
import java.util.List;

public class findMode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int cur;
    private int curtimes;
    private int lasttimes;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> res = new ArrayList<>();
        in(root, res);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private void in(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        in(root.left, res);

        if (lasttimes == 0) {
            lasttimes = 1;
        }
        if (root.val != cur) {
            curtimes = 0;
        }
        cur = root.val;
        curtimes++;
        // 如果出现的次数相等就加入res中
        if (curtimes == lasttimes) {
            res.add(cur);
        }
        // 如果是新的众数，次数大于以前的众数，则清空res，在把新的众数加入res中
        if (curtimes > lasttimes) {
            lasttimes = curtimes;
            res.clear();
            res.add(cur);
        }

        in(root.right, res);
    }

}

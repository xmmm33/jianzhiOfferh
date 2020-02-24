package day2.time_0224_1854;

import java.util.Arrays;

/**
 * 根据二叉树的前序和中序 重建二叉树
 */
public class reConstructBinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] mid) {
        if (pre.length == 0 || mid.length == 0 || pre.length != mid.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int pos = 0;
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == mid[i]) {
                // Arrays.copyOfRange(pre, 1, i + 1) 取出pre后面多少个数字，跟i有关
                // copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(mid, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i+1, mid.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},
                new int[]{4,7,2,1,5,3,8,6});
    }

}

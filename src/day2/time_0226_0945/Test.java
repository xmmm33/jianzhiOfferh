package day2.time_0226_0945;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将满二叉树转换为求和书
 * 二叉树：
 *                   10
 *                /      \
 *              -2        6
 *            /   \      /  \
 *           8    -4    7    5
 *
 * 求和树：
 *                  20(4-2+12+6)
 *                /      \
 *            4(8-4)      12(7+5)
 *             /   \      /  \
 *           0      0    0    0
 */
public class Test {

    public static class TreeNode {
        int val;
        int sum = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] prestring = sc.nextLine().split(" ");
        String[] minstring = sc.nextLine().split(" ");
        if (prestring.length < 1 || minstring.length < 1) {
            return;
        }
        int[] pre = new int[prestring.length];
        int[] mid = new int[minstring.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = Integer.parseInt(prestring[i]);
            mid[i] = Integer.parseInt(minstring[i]);
        }
        // 通过前序和中序重建二叉树
        TreeNode root = construct(pre, mid);
        countsum(root);
        zhongxubianli(root);
    }

    private static void zhongxubianli(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongxubianli(root.left);
        System.out.print(root.sum + " ");
        zhongxubianli(root.right);
    }

    private static void countsum(TreeNode root) {
        if (root == null) {
            return;
        }
        countsum(root.left);
        countsum(root.right);
        if (root.left == null && root.right == null) {
            root.sum = 0;
        }else {
            root.sum = root.left.val + root.right.val + root.left.sum + root.right.sum;
        }
    }

    private static TreeNode construct(int[] pre, int[] mid) {
        if (pre.length < 1 || mid.length < 1 || pre.length != mid.length) {
            return null;
        }
        TreeNode temp = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == mid[i]) {
                temp.left = construct(Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(mid, 0, i));
                temp.right = construct(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(mid, i + 1, mid.length));
                break;
            }
        }
        return temp;
    }
}

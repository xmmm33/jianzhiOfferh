package LeetCode1;

import java.util.Arrays;

public class buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据先序和中序还原二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }

    /**
     * 根据中序和后序还原二叉树
     */
    public TreeNode buildTree2(int[] inorder, int[] lastorder) {
        if (inorder == null || inorder.length < 1 || lastorder == null || lastorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(lastorder[lastorder.length - 1]);
        for (int i = 0; i <lastorder.length ; i++) {
            if (inorder[i] == lastorder[lastorder.length - 1]) {
                root.left = buildTree2(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(lastorder, 0, i));
                root.right = buildTree2(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(lastorder, i, lastorder.length - 1));
                break;
            }
        }
        return root;
    }
}

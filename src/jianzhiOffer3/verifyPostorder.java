package jianzhiOffer3;


/**
 * 判断数组序列是不是二叉搜索树的后序遍历
 * 倒着遍历数组，就是先序遍历的镜像
 */
public class verifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 1) {
            return false;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int rootindex) {
        if (i >= rootindex) {
            return true;
        }
        // 划分左右子树：遍历后序遍历的 [i, j]区间元素，
        // 寻找第一个大于根节点的节点，索引记为 m
        int p = i;
        while (postorder[p] < postorder[rootindex]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[rootindex]) {
            p++;
        }
        // 划分为左i--m-1；m--j右区间递归判断
        return p == rootindex && recur(postorder, i, m - 1) && recur(postorder, m, rootindex - 1);
    }
}

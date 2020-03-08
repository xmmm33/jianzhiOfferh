package day2.time_0302_1102;

/**
 * 求二叉树的最大深度
 */
public class getTreeDepth {

    int GetHeight(TreeNode root)
    {
        if (null == root) {
            return 0;
        }
        int left_count = GetHeight(root.left)+1;
        int right_count = GetHeight(root.right)+1;
        return left_count > right_count ? left_count : right_count ;
    }
}

package jindian3;

public class sortedArrayToBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 对一个排序的数组，重建一个最小高度的二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        // 把数组以中点分为两个部分，然后对左边重建树，右边重建树
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}

package LeetCode3;

public class lowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1、在左、右子树中分别查找是否包含p或q，如果（两种情况：左子树包含p，右子树包含q/左子树包含q，右子树包含p）;那么此时的根节点就是最近公共祖先
     * 2、如果左子树包含p和q，那么到root->left中查找，最近公共祖先在左子树里面
     * 3、如果右子树包含p和q，那么到root->right中查找，最近公共祖先在右子树里面
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // 说明pq在root节点的左右子树中
            return root;
        } else if (left != null) {
            // 说明pq在左子树中
            return left;
        }else  if (right != null){
            // 说明pq在右子树中
            return right;
        }
        return null;
    }
}

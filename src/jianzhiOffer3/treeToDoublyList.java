package jianzhiOffer3;


/**
 * 二叉树转换为双向链表
 */
public class treeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre , head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        zhongxu(root);
        // 这时候的pre节点就是中序遍历的最后一个节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void zhongxu(Node root) {
        if (root == null) {
            return;
        }
        zhongxu(root.left);
        if (pre != null) {
            pre.right = root;
        }else {
            // 找到双向链表的头结点
            head = root;
        }
        // 设置当前节点的前驱
        root.left = pre;
        // 更新前驱节点为当前节点
        pre = root;
        zhongxu(root.right);
    }
}

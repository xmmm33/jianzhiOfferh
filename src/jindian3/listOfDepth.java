package jindian3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class listOfDepth {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<ListNode> res = new ArrayList<>();

    // 广度遍历一个二叉树，返回每一层的节点
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        bfs(tree);
        return res.toArray(new ListNode[0]);
    }

    private void bfs(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode temp = new ListNode(-1);
            ListNode h = temp;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ListNode next = new ListNode(node.val);
                temp.next = next;
                temp = temp.next;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(h.next);
        }
    }
}

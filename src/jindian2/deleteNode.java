package jindian2;

public class deleteNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 删除链表中的某个元素
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            pre = node;
            ListNode next = node.next;
            node.val = node.next.val;
            node = next;
        }
        pre.next = node.next;
    }
}

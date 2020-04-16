package jianzhiOffer2;

public class deleteNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        while (cur != null) {
            int a = cur.val;
            if (a == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}

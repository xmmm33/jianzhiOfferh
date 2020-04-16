package jianzhiOffer2;

public class reverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 头插法反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = temp;
            temp = head;
            head = t;
        }
        return temp;
    }
}

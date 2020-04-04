package LeetCode2;

public class getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa = headA;
        ListNode tempb = headB;
        int alen = 0;
        while (tempa != null) {
            alen++;
            tempa = tempa.next;
        }
        int blen = 0;
        while (tempb != null) {
            blen++;
            tempb = tempb.next;
        }
        int len = alen > blen ? alen - blen : blen - alen;
        ListNode fast = alen > blen ? headA : headB;
        ListNode slow = alen > blen ? headB : headA;
        while (len > 0) {
            fast = fast.next;
            len--;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return null;
    }
}

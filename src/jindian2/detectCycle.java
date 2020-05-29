package jindian2;

public class detectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 链表环路检测
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = head;
        ListNode temp2 = slow.next;
        while (temp != temp2) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        return temp;
    }

    //
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = head;
        ListNode q = slow.next;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}

package jindian2;

public class partition {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 分割链表
    public ListNode partition(ListNode head, int x) {
        ListNode s1 = head;
        ListNode temp = new ListNode(-1);
        ListNode h = temp;
        while (s1 != null) {
            if (s1.val < x) {
                temp.next = new ListNode(s1.val);
                temp = temp.next;
            }
            s1 = s1.next;
        }
        s1 = head;
        while (s1 != null) {
            if (s1.val >= x) {
                temp.next = new ListNode(s1.val);
                temp = temp.next;
            }
            s1 = s1.next;
        }
        return h.next;
    }

    // 力扣解法 高低指针
    public ListNode partition2(ListNode head, int x) {
        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);
        ListNode h = low;
        ListNode hh = high;
        while (head != null) {
            if (head.val < x) {
                low.next = new ListNode(head.val);
                low = low.next;
            }else {
                high.next = new ListNode(head.val);
                high = high.next;
            }
            head = head.next;
        }
        if (hh.next != null) {
            low.next = hh.next;
        }
        return h.next;
    }
}

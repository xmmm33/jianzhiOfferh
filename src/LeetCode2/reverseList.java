package LeetCode2;

public class reverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode h = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = h;
            h = temp;
        }
        return h;
    }

    /**
     * 双指针反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 反转从m到n位置的链表元素
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = pre;
        ListNode tail = cur;

        while (n > 0) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n--;
        }
        if (con != null) {
            con.next = pre;
        }else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }
}

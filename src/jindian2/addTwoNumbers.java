package jindian2;

public class addTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // 正向链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        int jin = 0;
        while (l1 != null || l2 != null) {
            int a1 = l1 == null ? 0 : l1.val;
            int a2 = l2 == null ? 0 : l2.val;
            int val = a1 + a2 + jin;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            jin = val / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        while (jin > 0) {
            int val = jin % 10;
            temp.next = new ListNode(val);
            temp = temp.next;
            jin = jin / 10;
        }
        return head.next;
    }

    // 反向链表求和
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int a1 = 0;
        int a2 = 0;
        while (l1 != null) {
            a1 = a1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            a2 = a2 * 10 + l2.val;
            l2 = l2.next;
        }
        int res = a1 + a2;
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        char[] chars = String.valueOf(res).toCharArray();
        for (char c : chars) {
            temp.next = new ListNode(Integer.parseInt(String.valueOf(c)));
            temp = temp.next;
        }
        return head.next;
    }

}

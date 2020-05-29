package jindian2;

public class kthToLast {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 找到单项链表的倒数第k个节点  快慢指针
    public int kthToLast(ListNode head, int k) {
        ListNode s1 = head;
        ListNode s2 = head;
        while (k > 0) {
            s1 = s1.next;
            k--;
        }
        while (s1 != null && s2 != null) {
            s1 = s1.next;
            s2 = s2.next;
        }
        return s2.val;
    }
}

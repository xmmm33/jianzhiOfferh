package LeetCode1;

/**
 * 快慢指针
 */
public class removeNthFromEnd {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode be = head;
        ListNode pre = head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast == null ){
            head = be.next;
            return head;
        }
        while(fast!=null){
            pre = be;
            be = be.next;
            fast = fast.next;
        }
        pre.next = be.next;
        return head;
    }
}

package LeetCode1;

public class mergeTwoLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    /**
     * 合并两个有序的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode a = head;
        if(l1.val <= l2.val){
            head.next = l1;
            l1 = l1.next;
        }else{
            head.next = l2;
            l2 = l2.next;
        }
        head = head.next;
        while(l1 != null && l2!=null){
            ListNode temp = null;
            if(l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }else{
                temp = l2;
                l2 = l2.next;
            }
            head.next = temp;
            head = head.next;
        }
        if(l1 != null){
            head.next = l1;
        }
        if(l2 != null){
            head.next = l2;
        }
        return a.next;
    }
}

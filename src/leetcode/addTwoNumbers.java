package leetcode;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class addTwoNumbers {


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null){
            int x1 = l1 == null ? 0:l1.val;
            int x2 = l2 == null ? 0:l2.val;
            int sum = x1+x2+jin;
            jin = 0;
            ListNode temp = new ListNode(sum);
            res.next = temp;
            res = res.next;
            if(temp.val >= 10){
                jin = temp.val/10;
                res.val = temp.val%10;
            }
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }
        if(jin > 0){
            ListNode add = new ListNode(jin);
            res.next = add;
        }
        return head.next;
    }
}

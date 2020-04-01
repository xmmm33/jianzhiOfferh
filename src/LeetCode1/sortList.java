package LeetCode1;

public class sortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    /**
     * 冒泡排序 单链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null;
        while (cur.next != tail) {
            while (cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int temp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = temp;
                }
                cur = cur.next;
            }
            // 尾节点指向cur节点，这时候的cur节点总是指向最后一个节点
            tail = cur;
            cur = head;
        }
        return head;
    }
}

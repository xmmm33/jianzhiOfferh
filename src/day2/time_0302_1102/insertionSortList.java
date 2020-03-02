package day2.time_0302_1102;

/**
 * 使用插入排序对链表排序
 */
public class insertionSortList {

    public static class ListNode {
      int val;
      ListNode next;
 ListNode(int x) {
          val = x;
          next = null;
      }
  }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        insertionSortList(node1);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode ret = head;
        while(head != null){
            ListNode temp = head;
            while(temp.next != null){
                if (temp.next.val < temp.val) {
                    int val = temp.next.val;
                    temp.next.val = temp.val;
                    temp.val = val;
                }
                temp = temp.next;
            }
            head = head.next;
        }
        return ret;
    }
}

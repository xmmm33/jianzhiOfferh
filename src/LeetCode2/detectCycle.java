package LeetCode2;

import java.util.HashSet;
import java.util.Set;

public class detectCycle {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean f = false;
        ListNode slow = head;
        ListNode fast = head;
        // 找到第一次相遇
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                f = true;
                break;
            }
        }
        // 然后一个指针从头开始，一个指针从第一次相遇的节点开始
        if (f) {
            ListNode p1 = head;
            ListNode p2 = slow;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }else {
            return null;
        }
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> temp = new HashSet<>();
        while (head != null) {
            if (temp.contains(head)) {
                return head;
            }
            temp.add(head);
            head = head.next;
        }
        return null;
    }
}

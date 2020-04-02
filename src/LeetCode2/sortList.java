package LeetCode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode sortList(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }
        Collections.sort(temp);
        ListNode h = new ListNode(-1);
        ListNode res = h;
        for (Integer i : temp) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        return res.next;
    }

    /**
     * 归并排序单链表
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 中间节点
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(-1);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;
        return res.next;
    }

    /**
     * 插入排序单链表
     * @param head
     * @return
     */
    public ListNode sortList3(ListNode head) {
        ListNode h = new ListNode(-1);
        ListNode pre = h;
        ListNode cur = head;
        while (cur != null) {
            // 当前待插入节点
            ListNode temp = cur.next;
            // 从头开始遍历到待插入节点，找到待插入节点插入的位置前一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 插入操作
            cur.next = pre.next;
            pre.next = cur;
            pre = h;
            // 待插入节点后移
            cur = temp;
        }
        return h.next;
    }
}

package jindian2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class removeDuplicateNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // 移除重复的节点
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> temp = new LinkedHashSet<>();
        while (head != null) {
            temp.add(head .val);
            head = head.next;
        }
        ListNode h = new ListNode(-1);
        ListNode newh = h;
        for (Integer node : temp) {
            h.next = new ListNode(node);
            h = h.next;
        }
        return newh.next;
    }

    // 力扣解法
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> temp = new HashSet<>();
        ListNode h = new ListNode(-1);
        ListNode hh = h;
        while (head != null) {
            if (temp.contains(head.val)) {
                head = head.next;
                continue;
            }
            temp.add(head.val);
            h.next = new ListNode(head.val);
            h = h.next;
        }
        return hh.next;
    }
}

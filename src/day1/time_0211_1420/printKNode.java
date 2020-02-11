package day1.time_0211_1420;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印出单链表中倒数第K个节点
 */
public class printKNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 第一种解法
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        ArrayList<ListNode> tmp = new ArrayList<>();
        while (head != null) {
            tmp.add(0, head);
            head = head.next;
        }
        if (k >= tmp.size()) {
            return null;
        }else {
            return tmp.get(tmp.size() - k);
        }
    }

    /**
     * 第二种解法
     * 定义两个node，两个node之间相差k个节点，然后两个节点一起走，当右面的这个节点为null的时候，左边的节点就是倒数第K个节点。
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTailTwo(ListNode head,int k) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            // 这个循环是为了让右边的节点前进k个位置，同时判断k是否大于链表的长度。
            if (second == null) {
                return null;
            }
            second = second.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        if (first != null) {
            return first;
        } else {
            return null;
        }
    }
}

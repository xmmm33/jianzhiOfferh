package day1.time_0211_1420;

/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，合并这两个链表，合并后的链表单调不递减
 */
public class MergeTwoOrderedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 一共需要四个指针，第一个指针指向合并后的单链表的头结点 newhead
     *               第二个指针指向list1的节点 head1 如果list1的小于list2的值，那么把list1加入pre，list1往后移动
     *               第三个指向指向list2的节点 head2
     *               第四个指针指向较小那个单链表的当前节点 pre
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newhead = list1.val < list2.val ? list1 : list2;
        ListNode head1 = list1;
        ListNode head2 = list2;
        if (newhead == head1) {
            head1 = head1.next;
        }else {
            head2 = head2.next;
        }
        ListNode pre = newhead;

        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                pre.next = head1;
                pre = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                pre = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            pre.next = head2;
        }
        if (head2 == null) {
            pre.next = head1;
        }
        return newhead;
    }

    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode newhead = new ListNode(-1);
        ListNode cur = newhead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return newhead.next;
    }
}

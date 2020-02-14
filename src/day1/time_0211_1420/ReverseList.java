package day1.time_0211_1420;

/**
 * 反转链表
 *
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 需要三个指针, pre指向前一个，cur指向当前节点，next指向下一个节点
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head,
                 cur = head.next,
                 next = head.next.next;
        // 1. 将头换成尾，因为尾部的next为null，所以pre.next=null
        pre.next = null;
        // 然后从第二个node开始，就是cur开始，循环将cur.next 指向前一个即pre
        // 然后pre cur next节点依次往后移动
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        // 这里表示next为null了，但是pre和cur还没有进行交换，所以最后还需要交换一次
        cur.next = pre;
        return  cur;
    }

    public ListNode ReverseListTwo(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode pre = null;
        ListNode next = null;
        // 讲listNode的下一节点指向前一个节点，
        // 然后前一个节点、当前节点、后一个节点依次往后移动
        while (listNode != null) {
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        return pre;
    }

    /**
     * 使用头插法来逆序一个单链表
     * @param listNode
     * @return
     */
    public ListNode RevserListThree(ListNode listNode) {
        ListNode head = listNode;
        if (listNode == null) {
            return null;
        }
        while (listNode != null) {
            ListNode next = head.next;
            head.next = head.next;
            head.next = head;
            head = next;
        }
        return head.next;
    }
}

package day1.time_0212_1347;

/**
 * 寻找两个链表的第一个公共节点
 * 从这个节点开始，后面的都是一样的。
 */
public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        int k = 0;

        if (temp1 != null) {
            // 寻找链表之间长度的差值
            while (temp1 != null) {
                temp1 = temp1.next;
                k++;
            }
            temp1 = pHead1;
            temp2 = pHead2;
            // 先让长的链表走k步
            for (int i = 0; i < k; i++) {
                temp1 = temp1.next;
            }
            while (temp1.val != temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
        else {
            while (temp2 != null) {
                temp2 = temp2.next;
                k++;
            }
            temp1 = pHead1;
            temp2 = pHead2;
            for (int i = 0; i <k ; i++) {
                temp2 = temp2.next;
            }
            while (temp1.val != temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp2;
        }
    }
}

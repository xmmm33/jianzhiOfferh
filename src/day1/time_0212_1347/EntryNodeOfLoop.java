package day1.time_0212_1347;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 寻找链表中环的入口点
 */
public class EntryNodeOfLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 空间换时间的做法
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (!set.contains(pHead)) {
                set.add(pHead);
            }else {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }
}

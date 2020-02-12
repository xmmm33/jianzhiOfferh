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

        ListNode(Integer val) {
            this.val = val;
        }
    }

    /**
     * 空间换时间的做法
     * 把每个节点加入到set中，
     * 当第一次出现重复节点的时候，就说明出现环了
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


    /**
     * 解法2 使用快慢指针
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoopTwo(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        if (pHead == null) {
            return null;
        }
        // 这个循环就是判断是否有环
        // 快指针走两步
        // 慢指针走一步
        // slow == fast的时候就退出循环
        while (fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        // 如果slow走了l的长度，那么fast走了2l长度
        // 假如slow走到入口点的距离为s，在环内走了d的距离
        // 那么l = s + d
        // 假设环内 slow没走的长度是m，fast走的长度是 n*（m+d） + d + s = 2l ，代入l=s+d，得出s = m + （n-1）（m+d）
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}

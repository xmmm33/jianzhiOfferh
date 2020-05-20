package jianzhiOffer5;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 */
public class getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int cnt = 0;
        while (temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 == null) {
            while (temp2 != null) {
                temp2 = temp2.next;
                cnt++;
            }
            temp1 = headA;
            temp2 = headB;
            while (cnt > 0) {
                temp2 = temp2.next;
                cnt--;
            }
            while (temp1 != null && temp2 != null) {
                if (temp1 == temp2) {
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }else {
            while (temp1 != null) {
                temp1 = temp1.next;
                cnt++;
            }
            temp1 = headA;
            temp2 = headB;
            while (cnt > 0) {
                temp1 = temp1.next;
                cnt--;
            }
            while (temp1 != null && temp2 != null) {
                if (temp1 == temp2) {
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }


    /**
     * hashset
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> temp = new HashSet<>();
        while (headA != null) {
            temp.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (temp.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

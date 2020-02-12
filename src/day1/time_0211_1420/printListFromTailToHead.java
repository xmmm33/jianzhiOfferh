package day1.time_0211_1420;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 */
public class printListFromTailToHead {

    public static class ListNode {
        Integer val;
        ListNode next = null;

        ListNode(Integer val) {
            this.val = val;
        }
    }

    /**
     * 带头结点的单链表的创建
     * 头插法
     * 使得head始终指向头结点
     * @param array
     * @return
     */
    public static ListNode formLianbiao(int[] array) {
        ListNode head = new ListNode(null);
        ListNode header = head;
        for (int i = 0; i <array.length ; i++) {
            ListNode temp = new ListNode(array[i]);
            if (head == null) {
                head = temp;
            }else {
                temp.next = head;
                head = temp;
            }
        }
        return header;
    }

    /**
     * 尾插法构建单链表
     * 使得storage始终指向最后一个节点
     * @param array
     * @return
     */
    public static ListNode formLianbiaoTwo(int[] array) {
        ListNode head,storage,last;
        head = new ListNode(null);
        storage = last = null;
        for (int i = 0; i < array.length; i++) {
            last = new ListNode(array[i]);
            if (i == 0) {
                head.next = storage = last;
            }else {
                storage.next = last;
                storage = last;
            }
        }
        return head;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode node = listNode.next;
        while (node != null) {
            ret.add(0,node.val);
            node = node.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = printListFromTailToHead(formLianbiaoTwo(new int[]{5, 6, 8, 5, 54, 23, 54}));
        for (Integer i : integers) {
            System.out.println(i);
        }
    }
}

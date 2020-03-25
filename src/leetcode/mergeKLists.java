package leetcode;

import java.util.ArrayList;
import java.util.List;

public class mergeKLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 合并K个有序的链表
     * 暴力法：先把K个链表的数字全部输入到一个数组中进行排序
     * 然后循环构成链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> temp = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                temp.add(node.val);
                node = node.next;
            }
        }
        /*Collections.sort(temp);
        ListNode h = new ListNode(-1);
        ListNode head = h;
        for (int i = 0; i < temp.size(); i++) {
            h.next = new ListNode(temp.get(i));
            h = h.next;
        }*/
        int[] t = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            t[i] = temp.get(i);
        }
        buildheap(t);
        ListNode head = new ListNode(-1);
        for (int i = 0; i < t.length; i++) {
            head.next = new ListNode(t[i]);
            head = head.next;
        }
        return head.next;
    }

    private static void buildheap(int[] toArray) {
        if (toArray.length < 1) {
            return;
        }
        for (int i = toArray.length / 2 - 1; i >= 0; i--) {
            adjust(toArray, i, toArray.length);
        }
        for (int i = toArray.length-1; i >=0 ; i--) {
            int temp = toArray[i];
            toArray[i] = toArray[0];
            toArray[0] = temp;
            adjust(toArray, 0, i);
        }
        for (int i : toArray) {
            System.out.println(i);
        }
    }

    private static void adjust(int[] toArray, int parent, int length) {
        int temp = toArray[parent];
        for (int i = 2*parent+1; i <length ; i=2*i+1) {
            if (i + 1 < length && toArray[i] < toArray[i + 1]) {
                i++;
            }
            if (temp > toArray[i]) {
                break;
            }else {
                int tmp = toArray[parent];
                toArray[parent] = toArray[i];
                toArray[i] = tmp;
                parent = i;
            }
        }
    }

    public static void main(String[] args) {
        buildheap(new int[]{-10,-9,-9,-9,-7,-2,-1,2,4,-9,-7,-6,-6,-3,0,1,3,-10,-9,-2,-1,1,3});
    }
}

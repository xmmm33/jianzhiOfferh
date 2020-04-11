package jianzhiOffer1;

import java.util.ArrayList;
import java.util.List;

public class reversePrint {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int[] res = new int[length];
        int k = length - 1;
        while (head != null) {
            res[k--] = head.val;
            head = head.next;
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(0, head.val);
            head = head.next;
        }
        int[] resto = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resto[i] = res.get(i);
        }
        return resto;
    }
}

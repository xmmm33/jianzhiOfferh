package LeetCode3;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> sb = new ArrayList<>();
        while (head != null) {
            sb.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = sb.size() - 1;
        while (left < right) {
            if (!sb.get(left).equals(sb.get(right))) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-129);
        ListNode node2 = new ListNode(-129);
        node1.next = node2;
        node2.next = null;
        isPalindrome(node1);
    }
}

package jindian2;


import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 判断一个链表是不是回文链表
    public boolean isPalindrome(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }
        int low = 0;
        int high = temp.size() - 1;
        while (low < high) {
            if (temp.get(low).equals(temp.get(high))) {
                low++;
                high--;
            }else {
                return false;
            }
        }
        return true;
    }

    // 快慢指针判断回文链表
    public boolean isP(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 寻找链表的中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 现在slow指向就是中间节点
        // 然后需要翻转后半部分链表
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 然后比较两部分的链表每个元素是否相同
        ListNode temp = head;
        while (pre != null && temp != null) {
            if (pre.val != temp.val) {
                return false;
            }
            pre = pre.next;
            temp = temp.next;
        }
        return true;
    }
}

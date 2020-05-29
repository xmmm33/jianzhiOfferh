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
}

package day1.time_0212_1347;

import java.util.*;
public class Main{
    public static class ListNode{
        int m_nKey;
        public ListNode(int m_nKey){
            this.m_nKey = m_nKey;
        }
        ListNode m_pNext;
    }

    public static void main(String[] args){
        ListNode head = null;
        ListNode newhead = null;
        for(int i =0 ;i < 7; i++){
            if(i == 0){
                head = new ListNode(i+1);
                newhead = head;
            }else{
                head.m_pNext = new ListNode(i + 1);
                head = head.m_pNext;
            }
        }
        Scanner sc = new Scanner(System.in);
        int k = 0;
        while(sc.hasNextLine()){
            k = sc.nextInt();
            break;
        }
        findKthNode(newhead,k);
    }

    public static ListNode findKthNode(ListNode head , int k ){
        ListNode pre = head;
        ListNode next = head;
        for(int i =0 ;i<k;i++){
            if(next == null){
                return null;
            }
            next = next.m_pNext;
        }
        while (next != null ){
            pre = pre.m_pNext;
            next = next.m_pNext;
        }
        if (pre != null) {
            return pre;
        } else {
            return null;
        }
    }
}
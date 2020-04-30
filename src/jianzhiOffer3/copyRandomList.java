package jianzhiOffer3;


/**
 * 复杂链表的复制
 */
public class copyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node ppp = head;
        // 先复制一个节点到原节点后面一个节点
        while (ppp != null) {
            Node temp = new Node(ppp.val);
            temp.next = ppp.next;
            ppp.next = temp;
            ppp = ppp.next.next;
        }
        ppp = head;
        while (ppp != null && ppp.next != null) {
            if (ppp.random != null) {
                ppp.next.random = ppp.random.next;
            }else {
                ppp.next.random = null;
            }
            ppp = ppp.next.next;
        }
        // 把链表一分为2
        Node copyhead = head.next;
        ppp = head;
        Node copynode = copyhead;
        while (ppp != null) {
            ppp.next = ppp.next.next;
            ppp = ppp.next;
            if (copynode.next != null) {
                copynode.next = copynode.next.next;
                copynode = copynode.next;
            }
        }
        return copyhead;
    }
}

package day1.time_0211_1420;

/**
 * 复杂链表的复制
 *
 */
public class Clone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        formlianbiao(new int[]{1,2,3,4,5,3,5,2});
    }

    public static void formlianbiao(int[] array) {
        RandomListNode head = null;
        RandomListNode temp = null;
        for (int i = 0; i <array.length ; i++) {
            if (i == 0) {
                head = new RandomListNode(array[i]);
                temp = head;
            } else {
                head.next = new RandomListNode(array[i]);
                head.random = head;
                head = head.next;
            }
        }
        Clone(temp);
    }

    public static RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) {
            return null;
        }
        RandomListNode temp1 = pHead;
        // 复制原节点 插入到原节点的后面一个
        while (temp1 != null) {
            RandomListNode copy = new RandomListNode(temp1.label);
            copy.next = temp1.next;
            temp1.next = copy;
            temp1 = copy.next;
        }
        temp1 = pHead;
        // 复制源节点的random指针
        while (temp1 != null) {
            if (temp1.random != null) {
                temp1.next.random = temp1.random.next;
            }
            if (temp1.next != null) {
                temp1 = temp1.next.next;
            }
        }
        // 分类新旧链表
        temp1 = pHead;
        // 记录复制链表的头结点
        RandomListNode head = pHead.next;
        // 这个循环就是让temp1始终执行原链表的节点
        // head指向copy单链表的首节点
        // copy始终指向复制节点
        while (temp1 != null) {
            RandomListNode copy = temp1.next;
            temp1.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;
            temp1 = temp1.next;
        }
        return head;
    }
}

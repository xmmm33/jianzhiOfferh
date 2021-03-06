package day2.time_0227_1112;

/**
 * 堆排序练习
 */
public class DuiSortTest {
    public static void main(String[] args) {
        int[] ints = new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131};
        buildHeap(ints);
        heapSortTest(ints);
    }

    private static void heapSortTest(int[] ints) {
        if (ints.length == 0) {
            return;
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            int temp = ints[i];
            ints[i] = ints[0];
            ints[0] = temp;
            // 然后调整头结点，使得继续构成一个最大堆
            adjust(ints, 0, i);
        }
        for (int i : ints) {
            System.out.println(i);
        }
    }

    private static void buildHeap(int[] ints) {
        if (ints.length == 0) {
            return;
        }
        // 找到最后一个节点的父节点 就是i
        for (int i = ints.length - 2/ 2; i >= 0; i--) {
            adjust(ints, i, ints.length);
        }
    }

    private static void adjust(int[] ints, int parent, int length) {
        int temp = ints[parent];
        for (int i = 2 * parent + 1; i < length - 1; i = 2*i+1) {
            // 判断parent节点的左右子树谁更大，取更大的那个节点的索引i值
            if (i + 1 < length && ints[i] < ints[i + 1]) {
                i++;
            }
            // 判断parent节点是不是大于较大的子节点，如果大于，符合大根堆直接跳出循环
            if (temp >= ints[i]) {
                break;
            }else {
                // 否则，交换parent节点与i节点的值，然后使得parent指向较大子节点i，继续向下调整
                int tmp = ints[parent];
                ints[parent] = ints[i];
                ints[i] = tmp;
                parent = i;
            }
        }
    }
}

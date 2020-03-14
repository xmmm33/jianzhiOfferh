package practice.sort;

public class heap {

    public static void heap(int[] array) {
        buildmaxheap(array);
        heapsort(array);
    }

    private static void heapsort(int[] array) {
        if (array.length == 0) {
            return;
        }
        // 大根堆 数组的首元素一定是最大的，所以每次交换首部和尾部，然后再对剩余的元素进行堆调整
        for (int i = array.length-1; i >0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjust(array, 0, i);
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void buildmaxheap(int[] array) {
        if (array.length < 1) {
            return;
        }
        // 从最后一个节点的父节点开始构造大根堆
        for (int j = (array.length-2)/2; j >= 0 ; j--) {
            adjust(array, j, array.length);
        }
    }

    private static void adjust(int[] array, int parent, int length) {
        int temp = array[parent];
        // 从父节点的孩子节点开始
        for (int i = 2*parent+1; i < length-1; i = 2*i+1) {
            // 找到较大的那个孩子节点的下标
            if (i + 1 < length && array[i] < array[i+1]) {
                i++;
            }
            // 比较父节点和较大孩子节点
            if (temp > array[i]) {
                break;
            }else {
                int tmp = array[parent];
                array[parent] = array[i];
                array[i] = tmp;
                parent = i;
            }
        }
    }

    public static void main(String[] a) {
        heap(new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131});
    }
}

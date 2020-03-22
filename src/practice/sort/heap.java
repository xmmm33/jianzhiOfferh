package practice.sort;

/**
 * 堆排序 Onlogn
 * 建堆 On 调整堆 nlogn
 */
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
        for (int i = 2*parent+1; i < length; i = 2*i+1) {
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

    public static void main(String[] a2) {
        int[] a = new int[]{1, 5, 6, 1, 32, 5, 4, 5, 1, 2, 54, 3, 131};
        heap(a);
        for (int s : a) {
            System.out.println(s);
        }
    }

    public static void heap3(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        build3(arr);
        for (int i = arr.length-1; i >0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }
    }

    private static void build3(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjust3(arr, i, arr.length);
        }
    }

    private static void adjust3(int[] arr, int parent, int length) {
        int temp = arr[parent];
        for (int i = 2*parent+1; i < length; i = 2*i+1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (temp > arr[i]) {
                break;
            }else {
                arr[parent] = arr[i];
                parent = i;
            }
        }
        arr[parent] = temp;
    }
}

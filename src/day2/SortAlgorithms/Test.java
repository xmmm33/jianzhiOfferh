package day2.SortAlgorithms;

public class Test {

    public static void maopao(int[] array) {
        if (array.length < 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        if (array.length < 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j + 1] = temp;
            }
        }
    }

    public static void shellsort(int[] array) {
        if (array.length < 1) {
            return;
        }
        int len = array.length;
        // 希尔增量
        for (int gap = len / 2; gap >= 1; gap = gap / 2) {
            // 从gap元素开始向前比比较 array[i] 与 array[i-gap] array[i-gap-gap] ...依次比较交换
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap && array[j - gap] > array[j]; j=j-gap) {
                    int temp = array[j - gap];
                    array[j - gap] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void guibingSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        guibingSort(array, left, mid);
        guibingSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[array.length];
        int leftpoint = left;
        int rightpoint = mid + 1;
        int k = leftpoint;
        while (leftpoint <= mid && rightpoint <= right) {
            if (array[leftpoint] > array[rightpoint]) {
                temp[k++] = array[leftpoint++];
            }else {
                temp[k++] = array[rightpoint++];
            }
        }
        while (leftpoint <= mid) {
            temp[k++] = array[leftpoint++];
        }
        while (rightpoint <= right) {
            temp[k++] = array[rightpoint++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int basevalue = array[left];
        int leftpoint = left;
        int rightpoint = right;
        while (leftpoint < rightpoint) {
            while (leftpoint < rightpoint && array[rightpoint] >= basevalue) {
                rightpoint--;
            }
            array[leftpoint] = array[rightpoint];
            while (leftpoint < rightpoint && array[leftpoint] <= basevalue) {
                leftpoint++;
            }
            array[rightpoint] = array[leftpoint];
        }
        array[leftpoint] = basevalue;
        // 或者
        array[rightpoint] = basevalue;
        quickSort(array, left, leftpoint);
        quickSort(array, rightpoint + 1, right);
    }
}

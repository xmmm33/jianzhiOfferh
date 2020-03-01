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
}

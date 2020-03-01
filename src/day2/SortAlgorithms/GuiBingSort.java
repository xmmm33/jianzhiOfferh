package day2.SortAlgorithms;

/**
 * 归并排序 O(nlogn)
 * 用到了分治的思想
 * 首先是对数组进行等分，然后在进行分组，直到每个分组有序
 * 然后进行合并，把两个有序的合并为一个有序的
 */
public class GuiBingSort {

    public static void main(String[] agrs) {
        int[] a = new int[]{54, 21, 6, 4, 56, 1, 13, 45, 131, 5};
        guibingSort(a, 0, a.length - 1);
    }

    public static void guibingSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 对左边序列进行归并排序
            guibingSort(array, left, mid);
            // 对右边序列进行归并排序
            guibingSort(array, mid + 1, right);
            // 合并两个有序的序列
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // 辅助数组
        int[] temp = new int[array.length];
        int leftpoint = left;
        int rightpoint = mid + 1;
        int k = leftpoint;
        while (leftpoint <= mid && rightpoint <= right) {
            if (array[leftpoint] <= array[rightpoint]) {
                temp[k++] = array[leftpoint++];
            }else {
                temp[k++] = array[rightpoint++];
            }
        }
        // 如果左边序列没有检测完，直接将后面所有元素加入temp数组中
        while (leftpoint <= mid) {
            temp[k++] = array[leftpoint++];
        }
        // 右边同理
        while (rightpoint <= right) {
            temp[k++] = array[rightpoint++];
        }
        // 复制回原数组
        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }


}

package day2.SortAlgorithms;

/**
 * 快速排序
 * 基于冒泡排序的改进，是一种分区交换的思想
 * 一趟快速排序采用从两头向中间扫描的方法，同时交换与基准记录逆序的记录
 * 快速排序不想归并排序需要额外的辅助存储空间
 * 思想：取一个基准值，把数组分成两个，一个是比基准值小的，一个是比基准值大的
 */
public class QuickSort {

    public static void main(String[] agrs) {
        int[] a = new int[]{54, 21, 6, 4, 56, 1, 13, 45, 131, 5};
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int lefepoint = left;
        int rightpoint = right;
        // 待排序的第一个元素作为基准值
        int basevalue = array[lefepoint];
        while (lefepoint < rightpoint) {
            // 从右边往左边扫描，找到第一个比基准值小的元素
            while (rightpoint > lefepoint && array[rightpoint] >= basevalue) {
                rightpoint--;
            }

            // 找到比基准值小的元素将rightpoint的值放入leftpoint中
            array[lefepoint] = array[rightpoint];

            // 从左边开始扫描，扎到第一个比基准值大的元素
            while (rightpoint > lefepoint && array[lefepoint] <= basevalue) {
                lefepoint++;
            }
            array[rightpoint] = array[lefepoint];
        }
        // 将基准值归位 此时基准值左边的都比基准值小，右边的都比基准值大
        array[lefepoint] = basevalue;
        // 对基准值左边的元素进行递归排序
        quickSort(array, left, lefepoint - 1);
        // 对基准值右边的元素进行递归排序
        quickSort(array, rightpoint + 1, right);
    }
}

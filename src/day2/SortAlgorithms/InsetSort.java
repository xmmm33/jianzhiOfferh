package day2.SortAlgorithms;

/**
 * 插入排序
 */
public class InsetSort {

    public static void main(String[] agrs) {
        int[] a = new int[]{54, 21, 6, 4, 56, 1, 13, 45, 131, 5};
        insertSort(a);
    }

    private static void insertSort(int[] a) {
        // 排序的趟数 需要n-1趟,从第二个数开始比较
        for (int i = 1; i < a.length; i++) {
            // 每趟排序需要的次数，从后往前
            for (int j = i-1; j >=0 && a[j] > a[j+1]; j--) {
                int temp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = temp;
            }
        }
    }

}

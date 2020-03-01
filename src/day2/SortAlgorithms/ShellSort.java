package day2.SortAlgorithms;

/**
 * 希尔排序 不稳定
 * 基于插入排序的一种优化
 * 因为插入排序交换的次数太多了
 * 所以希尔排序定义了一种间隔的思想，
 */
public class ShellSort {


    public static void main(String[] agrs) {
        int[] a = new int[]{54, 21, 6, 4, 56, 1, 13, 45, 131, 5};
        Test.shellsort(a);
        shellsort(a);
    }


    public static void shellsort(int[] array) {
        if (array.length < 1) {
            return;
        }
        int N = array.length;
        //希尔增量
        for(int h = N / 2; h > 0; h /= 2){
            for(int i = h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...中
                for(int j = i; j >= h && array[j] < array[j - h]; j -= h){
                    int temp = array[j];
                    array[j] = array[j-h];
                    array[j-h] = temp;
                }
            }
        }
    }
}

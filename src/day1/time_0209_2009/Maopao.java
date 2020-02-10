package day1.time_0209_2009;

/**
 * 冒泡排序
 */
public class Maopao {

    private static void sort(int[] array) {
        // 外层循环控制一共需要多少次循环
        for (int i = 0; i <array.length ; i++) {
            // 内层循环控制一趟循环需要比较多少次
            for (int j = 0; j <array.length - i - 1 ; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        sort(new int[]{5,4,2,3,4,2,1});
    }
}

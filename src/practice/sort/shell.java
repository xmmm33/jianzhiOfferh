package practice.sort;

public class shell {

    public static void shell(int[] array) {
        if (array.length < 1) {
            return;
        }
        // 定义步长
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            // 找打步长所在位置元素
            for (int i = gap; i < array.length; i = i + gap) {
                // 跟步长所在以前的元素开始比较
                for (int j = i; j >= gap; j = j - gap) {
                    if (array[j] < array[j - gap]) {
                        int temp = array[j - gap];
                        array[j - gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 升级版的插入排序
     */
    public static void shell2(int[] array) {
        if (array.length < 1) {
            return;
        }
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i <array.length ; i = i+gap) {
                for (int j = i; j >0 ; j=j-gap) {
                    if (array[j] > array[j - gap]) {
                        int temp = array[j];
                        array[j] = array[j - gap];
                        array[j-gap] = temp;
                    }
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] a) {
        shell2(new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131});
    }
}

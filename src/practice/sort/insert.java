package practice.sort;

public class insert {

    public static void insert(int[] array) {
        if (array.length < 1
        ) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insert2(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] a) {
        insert2(new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131});
    }
}

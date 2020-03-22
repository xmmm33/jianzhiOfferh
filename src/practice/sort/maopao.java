package practice.sort;

public class maopao {

    public static void maopao(int[] array) {
        if (array.length < 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void maopao2(int[] a) {
        if (a.length < 1) {
            return;
        }
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-1 ; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] a) {
        maopao2(new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131});
    }
}

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

    public static void main(String[] a) {
        insert(new int[]{1,5,6,1,32,5,4,5,1,2,54,3,131});
    }
}

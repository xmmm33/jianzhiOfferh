package practice.sort;

/**
 * 选择排序 On^2
 */
public class choose {

    public static void choose(int[] array) {
        if (array.length < 1) {
            return;
        }
        for (int i = 0; i <array.length -1; i++) {
            int maxindex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[maxindex]) {
                    maxindex = j;
                }
            }
            int temp = array[maxindex];
            array[maxindex] = array[i];
            array[i] = temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] a) {
        choose(new int[]{1, 5, 64, 31, 21, 54, 846, 4, 313});
    }
}

package LeetCode1;

public class threecolor {

    public static void three(int[] array) {
        int w =0;
        int b = 0;
        int r = array.length - 1;
        while (w <= r) {
            if (array[w] == -1) {
                w++;
            } else if (array[w] == 1) {
                int temp = array[b];
                array[b] = array[w];
                array[w] = temp;
                w++;
                b++;
            } else if (array[w] == 0) {
                int temp = array[r];
                array[r] = array[w];
                array[w] = temp;
                r--;
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        three(new int[]{-1, -1, 0, 0, 1, 1});
    }
}

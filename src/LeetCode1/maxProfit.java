package LeetCode1;

public class maxProfit {

    public static int maxProfit(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        int low = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i] < low) {
                low = array[i];
            }
            max = Math.max(max, array[i] - low);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 465, 45, 42, 5, 46, 44}));
    }
}

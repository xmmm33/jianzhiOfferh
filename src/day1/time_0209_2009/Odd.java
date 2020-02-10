package day1.time_0209_2009;

import java.util.Arrays;

/**
 * 调整数组顺序
 * 奇数位于数组前半部分
 * 偶数位于数组后半部分
 * 并保证奇数和偶数的相对位置不变
 */
public class Odd {

    public static void main(String[] args) {
        dosth(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    private static void dosth(int[] array) {
        int[] ret = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                ret[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ret[j++] = array[i];
            }
        }
        System.arraycopy(ret,0,array,0,ret.length);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

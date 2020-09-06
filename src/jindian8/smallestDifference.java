package jindian8;

import java.util.Arrays;

public class smallestDifference {


    // 最小差

    /**
     * 定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     *
     * 示例：
     * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
     * 输出： 3，即数值对(11, 8)
     * @param a
     * @param b
     * @return
     */
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int k = 0, j = 0;
        while (k < a.length && j < b.length) {
            long detal = a[k] - b[j];
            min = (int) Math.min(Math.abs(detal), min);
            if (detal < 0) {
                k++;
            }else {
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        smallestDifference(new int[]{-2147483648,1}, new int[]{2147483647,0});
    }
}

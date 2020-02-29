package day2.time_0229_1225;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，
 */
public class FindGreatestSumOfSubArray {

    /**
     * 思路：就是从6开始加 首先加-3等于3 大于-3 说明从6开始比从-3开始好
     * 然后就是加-2 等于1 ，还是比-2大，说明从6开始比从-2开始好
     * 然后就是加7等于8，还是比7大，说明从6开始比从7开始好
     * 然后就是加-15等于-7，还是比-15大，说明从6开始比从-15开始好
     * 然后就是加1等于-6，此时-6小于1，说明从1开始比从-15开始好，把前面的最大值记录，并舍弃，并重新计算
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i <array.length ; i++) {
            // 第一次初始化max
            if (i == 0) {
                max = max + array[i];
            }
            // temp表示每次走到转折点的最大值 与全局最大值max比较
            // 这个if就是在进行比较
            if (temp + array[i] < array[i]) {
                // 表示重新定义起点了
                temp = array[i];
            }else {
                // 继续进行累加
                temp = temp + array[i];
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}

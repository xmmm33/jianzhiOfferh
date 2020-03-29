package leetcode;

import java.util.*;

public class merge {

    /**
     * 合并区间
     */
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length <1) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length-1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] a = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}

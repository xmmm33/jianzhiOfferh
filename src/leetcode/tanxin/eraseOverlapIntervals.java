package leetcode.tanxin;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 寻找不重叠区间
 *
 */
public class eraseOverlapIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按照每个区间的最后一个元素的大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int end = intervals[0][1];
        // 这里就是为了找到不重叠空间的个数
        // 然后用数组长度减去这个个数就是要删除的区间个数
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }
}

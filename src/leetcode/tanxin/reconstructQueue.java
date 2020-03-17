package leetcode.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重建升高队列
 */
public class reconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        // h降序，k升序
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        // 然后将某个学生插入队列的第 k 个位置中
        for(int[] p : people){
            res.add(p[1],p);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}

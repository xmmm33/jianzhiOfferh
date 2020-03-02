package day2.time_0302_1102;

import java.util.HashMap;

/**
 * 求最大几个点在同一直线上
 */
public class maxPoints {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }
        int ret = 0;
        for (int i = 0; i < len; i++) {
            // 分别统计与点i重合以及垂直的点的个数
            // 自己跟自己也算，所以初始值为1
            int dup = 1, vtl = 0;
            HashMap<Float, Integer> temp = new HashMap<>();
            Point a = points[i];
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                Point b = points[j];
                // 两个点可能重合，可能垂直
                if(a.x == b.x) {
                    if(a.y == b.y) dup++;
                    else vtl++;
                } else {
                    float k = (float) ((a.y - b.y) / (a.x - b.x));
                    temp.put(k, temp.getOrDefault(k, 0) + 1);
                }
            }
            int max = vtl;
            for (float k : temp.keySet()) {
                max = Math.max(max, temp.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
        return ret;
    }

}

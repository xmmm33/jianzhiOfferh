package leetcode.BFS;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 * 采用队列辅助
 */
public class bfs {

    /**
     * 广度优先遍历的常规套路
     * void BFS()
     * {
     *     定义队列;
     *     定义备忘录，用于记录已经访问的位置；
     *
     *     判断边界条件，是否能直接返回结果的。
     *
     *     将起始位置加入到队列中，同时更新备忘录。
     *
     *     while (队列不为空) {
     *         获取当前队列中的元素个数。
     *         int size = queue.size();
     *         for (i in size) {
     *             取出一个位置节点。
     *             判断是否到达终点位置。
     *             获取它对应的下一个所有的节点。
     *             条件判断，过滤掉不符合条件的位置。
     *             新位置重新加入队列。
     *             出队元素
     *             queue.pop();
     *         }
     *     }
     *
     * }
     */

    /**
     * 寻找矩阵最短路径
     * @param grid
     * @return
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rowlength = grid.length;
        int cloumlength = grid[0].length;
        // 表示能往哪个方向走的数组
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            // 对每一层进行遍历
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey();
                int cc = cur.getValue();
                // 当前节点是1表示不能走
                if (grid[cr][cc] == 1) {
                    continue;
                }
                if (cr == rowlength - 1 && cc == cloumlength - 1) {
                    return length;
                }
                // 走过的点标记为1
                grid[cr][cc] = 1;
                // 判断下一个能走的节点 加入队列中
                for (int[] d : direction) {
                    int nextr = cr + d[0];
                    int nextc = cc + d[1];
                    if (nextc < 0 || nextr < 0 || nextr >= rowlength || nextc >= cloumlength) {
                        continue;
                    }
                    queue.add(new Pair<>(nextr, nextc));
                }
            }
        }
        return -1;
    }

    public static int numSquares(int n) {
        if (n <= 0) {
            return -1;
        }
        List<Integer> seq = gen(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int s : seq) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return res;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    private static List<Integer> gen(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        while (square <= n) {
            squares.add(square*square);
            square = square + 1;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(numSquares(12));
    }

}

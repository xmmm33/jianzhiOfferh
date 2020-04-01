package LeetCode1;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxDistance {

    /**
     * 一开始，我们找出所有陆地格子，将它们放入队列，作为第 0 层的结点。
     * 然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
     * 当遍历结束时，当前的遍历层数就是海洋格子到陆地格子的最远距离。
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 遍历上方单元格
                if (r-1 >= 0 && grid[r-1][c] == 0) {
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                }
                // 遍历下方单元格
                if (r+1 < N && grid[r+1][c] == 0) {
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                }
                // 遍历左边单元格
                if (c-1 >= 0 && grid[r][c-1] == 0) {
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c-1});
                }
                // 遍历右边单元格
                if (c+1 < N && grid[r][c+1] == 0) {
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                }
            }
        }
        return distance;
    }
}

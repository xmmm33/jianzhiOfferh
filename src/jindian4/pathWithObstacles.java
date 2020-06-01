package jindian4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pathWithObstacles {


    private List<List<Integer>> res = new ArrayList<>();

    // 走矩阵 ggg
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        bfs(obstacleGrid, 0, 0, r, c, res, new boolean[r][c]);
        return res;
    }

    private boolean bfs(int[][] obstacleGrid, int row, int col, int r, int c, List<List<Integer>> res, boolean[][] visited) {
        if (row >= r || col >= c || obstacleGrid[row][col] == 1 || visited[row][col]) {
            return false;
        }
        res.add(Arrays.asList(row, col));
        if (row == r - 1 && col == c - 1) {
            return true;
        }
        visited[row][col] = true;
        if (bfs(obstacleGrid, row + 1, col, r, c, res, visited) || bfs(obstacleGrid, row, col + 1, r, c, res, visited)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}

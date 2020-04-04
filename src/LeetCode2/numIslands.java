package LeetCode2;

public class numIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int iland = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    iland++;
                    dfs(grid, i, j);
                }
            }
        }
        return iland;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
        }
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}

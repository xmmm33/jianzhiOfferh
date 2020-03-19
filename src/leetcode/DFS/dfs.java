package leetcode.DFS;

public class dfs {

    /**
     * 寻找最大连通的岛
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // 找到从当前节点出发，左右上下能连通的最大岛屿数目
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    public static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        // 标记访问过的元素
        grid[i][j] = 0;
        int num = 1;
        // 往右边走，走到不能走为止，得到右边的最大连通的岛
        num = num + dfs(i + 1, j, grid);
        // 往左边走，走到不能走为止，得到左边的最大连通的岛数量
        num = num + dfs(i - 1, j, grid);
        num = num + dfs(i, j + 1, grid);
        num = num + dfs(i, j - 1, grid);
        return num;
    }

    /**
     * 计算岛的数量
     */
    public static int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    // 从一个节点开始找 是否该点能形成一个
                    dfstwo(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfstwo(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i > grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = '0';
        dfstwo(i + 1, j, grid);
        dfstwo(i - 1, j, grid);
        dfstwo(i, j + 1, grid);
        dfstwo(i, j - 1, grid);
    }
}

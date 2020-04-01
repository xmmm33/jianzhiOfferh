package LeetCode1.DFS;

/**
 * 计算朋友圈个数
 */
public class findCircleNum {

    /**
     * 题目给出的矩阵实际上是一个邻接矩阵，
     * 因此这个题目就抽象成了已知邻接矩阵，求这个图的连通分量个数这样一个问题，
     * 为了找到连通块的个数，一个简单的方法就是使用深度优先搜索，从每个节点开始，我们使用一个大小为 NN 的 visitedvisited 数组（MM 大小为 N \times NN×N），
     * 这样 visited[i]visited[i] 表示第 i 个元素是否被深度优先搜索访问过。
     * 我们首先选择一个节点，访问任一相邻的节点。然后再访问这一节点的任一相邻节点。这样不断遍历到没有未访问的相邻节点时，回溯到之前的节点进行访问。
     */
    public int findCircleNum(int[][] M) {
        // 使用深度优先搜索，类似岛屿个数的题目
        boolean[] vis = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            // 如果没有访问过的节点才dfs
            if (!vis[i]) {
                dfs(M, i, vis);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] M, int i, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (!vis[j] && M[i][j] == 1) {
                dfs(M,j,vis);
            }
        }
    }
}

package jindian3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class linjietulianxi {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 先把graph准换为邻接矩阵
        List<Integer>[] adj = new ArrayList[n];
        for (int[] temp : graph) {
            int from = temp[0];
            int to = temp[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }
        return hashPath(n, adj, start, target);
    }

    private boolean hashPath(int n, List<Integer>[] adj, int start, int target) {
        // 用一个队列保存从节点0出发能到达的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        // 用一个标记数组来标识某一个节点是否被访问过
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextlist = adj[node];
                for (Integer next : nextlist) {
                    if (next == target) {
                        return true;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}

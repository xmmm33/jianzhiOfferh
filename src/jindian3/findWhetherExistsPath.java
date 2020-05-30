package jindian3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class findWhetherExistsPath {


    // 有向图寻找是否存在通路
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 首先把graph转换为邻接表
        List<Integer>[] lj = new ArrayList[n];
        for (int[] temp : graph) {
            int from = temp[0];
            int to = temp[1];
            if (lj[from] == null) {
                lj[from] = new ArrayList<>();
            }
            lj[from].add(to);
        }
        // 然后进行广度优先遍历bfs
        return hashPath(n, lj, start, target);
    }

    private boolean hashPath(int n, List<Integer>[] lj, int start, int target) {
        // 维护一个队列，表示从0节点能到达的所有节点
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        // 维护一个数组，表示哪些元素已经入队了
        boolean[] visited = new boolean[n];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> adj = lj[node];
                if (adj == null) {
                    continue;
                }
                for (Integer next : adj) {
                    if (next == target) {
                        return true;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}

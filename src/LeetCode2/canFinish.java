package LeetCode2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class canFinish {

    /**
     * 1. 初始化一个int[] inDegree保存每一个结点的入度。
     * 2. 对于图中的每一个结点的子结点，将其子结点的入度加1。
     * 3. 选取入度为0的结点开始遍历，并将该节点加入输出。
     * 4. 对于遍历过的每个结点，更新其子结点的入度：将子结点的入度减1。
     * 5. 重复步骤3，直到遍历完所有的结点。
     * 6. 如果无法遍历完所有的结点，则意味着当前的图不是有向无环图。不存在拓扑排序。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        // 入度表
        int[] inDegree = new int[numCourses];
        // 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 生成入度表inDegree和领接表adjacency
        for (int[] parent : prerequisites) {
            inDegree[parent[0]]++;
            adjacency.get(parent[1]).add(parent[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        // 找到入度为0的节点 加入到队列deque中
        for (int i = 0; i <numCourses ; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        // 进行bfs拓扑排序
        while (!deque.isEmpty()) {
            // 拓扑排序出队次数等于课程个数
            int cur = deque.poll();
            res.add(cur);
            numCourses--;
            for (int child : adjacency.get(cur)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        canFinish(2, new int[][]{{0,1}});
    }
}

package LeetCode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> top = new LinkedList<>();
        int[] ret = new int[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] parent : prerequisites) {
            indegree[parent[0]]++;
            adj.get(parent[1]).add(parent[0]);
        }
        // 找到入度为0的节点
        for (int i = 0; i <numCourses ; i++) {
            if (indegree[i] == 0) {
                top.offer(i);
            }
        }
        int k = 0;
        while (!top.isEmpty()) {
            int curpoint = top.poll();
            numCourses--;
            ret[k++] = curpoint;
            for (int child : adj.get(curpoint)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    top.offer(child);
                }
            }
        }
        if (numCourses == 0) {
            return ret;
        }else {
            return new int[numCourses];
        }
    }
}

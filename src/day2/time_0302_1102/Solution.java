package day2.time_0302_1102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {


    /**
     * 思路：使用层次遍历，第一次遇到叶子节点就返回，这就是最小深度
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int depth = 0;
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            depth++;
            for (int i = 0; i < len; i++) {
                TreeNode temp = nodes.poll();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    nodes.offer(temp.left);
                }
                if (temp.right != null) {
                    nodes.offer(temp.right);
                }
            }
        }
        return 0;
    }

    public int runTwo(TreeNode root) {
        ArrayList<Integer> holder = new ArrayList<>();
        if(root == null){
            return 0;
        }
        DFS(root,1,holder);
        return Collections.min(holder);
    }

    public void DFS(TreeNode root,int depth,ArrayList<Integer> holder){
        if(root.left == null && root.right == null){
            holder.add(depth);
        }

        if(root.left != null){
            DFS(root.left,depth+1,holder);
        }

        if(root.right != null){
            DFS(root.right,depth+1,holder);
        }
    }
}

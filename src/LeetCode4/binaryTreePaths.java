package LeetCode4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class binaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new ArrayList<String>(){
            @Override
            public String toString() {
                Iterator<String> it = iterator();
                StringBuilder sb = new StringBuilder();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                return sb.toString();
            }
        });
        return res;
    }

    private void dfs(TreeNode root, List<String> res, ArrayList<String> path) {
        if (root == null) {
            return;
        }
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        }else {
            String temp = path.get(path.size() - 1);
            temp = temp + "->";
            path.remove(path.size() - 1);
            path.add(temp);
        }
        dfs(root.left, res, path);
        dfs(root.right, res, path);
        // 回溯
        path.remove(path.size() - 1);
    }
}

package day2.time_0226_0945;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到二叉树中路径和为某一个值的所有路径
 * 路径长度长的在前面
 */
public class FindValuePath {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 前序遍历完成
     * list是用来保存节点路径的
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 因为result.add(list)是吧list这个对象的引用地址添加到result了
            // 这里要用new list 是因为直接addlist的话，result中始终会指向同一个list
            if (result.size() != 0 && list.size() > result.get(0).size()) {
                result.add(0,new ArrayList<>(list));
            }else {
                result.add(new ArrayList<>(list));
            }
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 这是在深度遍历完一条路径之后回溯 需要删除这个list中的最后一个节点
        list.remove(list.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = init(new int[]{10,5,15,3,7,13,18});
    }

    /**
     * 构建满二叉树
     * @param array
     * @return
     */
    public static TreeNode init(int[] array) {
        List<TreeNode> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            temp.add(new TreeNode(array[i]));
        }
        for (int i = 0; i <= array.length/2 - 1; i++) {
            temp.get(i).left = temp.get(2 * i + 1);
            temp.get(i).right = temp.get(2 * i + 2);
        }
        return temp.get(0);
    }
}

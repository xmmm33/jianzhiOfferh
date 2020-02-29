package day2.time_0229_1225;

import java.util.ArrayList;

/**
 * 序列化和反序列二叉树
 * 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）
 */
public class Serialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<String> list = new ArrayList<>();
    /**
     * 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串
     * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        pre(root);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    private void pre(TreeNode root) {
        if (root == null) {
            list.add("#");
            return;
        }
        list.add(String.valueOf(root.val));
        pre(root.left);
        pre(root.right);
    }

    /**
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     *
     * @param str
     * @return
     */
    int index = -1;
    TreeNode Deserialize(String str) {
        String[] strings = str.split(" ");
        index++;
        int len = strings.length;
        if (index > len) {
            return null;
        }
        TreeNode node = null;
        // 不是叶子节点继续走，是叶子节点出递归
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        Serialize serializeTree = new Serialize();

        String str = serializeTree.Serialize(treeNode1);
        TreeNode treeNode = serializeTree.Deserialize(str);
    }
}

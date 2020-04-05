package LeetCode3;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 序列化
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        res = helpser(root, new StringBuilder());
        return res.toString();
    }

    private StringBuilder helpser(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null,");
            return stringBuilder;
        }
        stringBuilder.append(root.val).append(",");
        stringBuilder = helpser(root.left, stringBuilder);
        stringBuilder = helpser(root.right, stringBuilder);
        return stringBuilder;
    }

    int index = 0;
    // 反序列化
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode root = helpde(nodes);
        return root;
    }

    private TreeNode helpde(String[] nodes) {
        if (nodes[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        root.left = helpde(nodes);
        root.right = helpde(nodes);
        return root;
    }
}

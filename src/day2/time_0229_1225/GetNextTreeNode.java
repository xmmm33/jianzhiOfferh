package day2.time_0229_1225;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个节点
 * 请找出中序遍历的下一个节点
 */
public class GetNextTreeNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先找右子树，如果存在，就一直找到右子树的最左边就是下一个节点
     * 如果没有右子树，就寻找他的父节点，一直找到它是父节点的左子树，打印父节点
     * 这个有问题
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode temp = pNode;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }else {
            TreeLinkNode temp = pNode;
            while (temp.next != null) {
                if (temp.next.left == temp) {
                    return temp.next;
                }else {
                    temp = temp.next;
                }
            }
            return null;
        }
    }

    private List<TreeLinkNode> linkNodes = new ArrayList<>();
    /**
     * 先找到根节点 然后中序遍历 然后去中序遍历结果里面找
     */
    public TreeLinkNode getNextTwo(TreeLinkNode node) {
        TreeLinkNode temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }
        zhongxutwo(temp);
        for (int i = 0; i <linkNodes.size() ; i++) {
            if (linkNodes.get(i) == node && i+1 < linkNodes.size()) {
                return linkNodes.get(i + 1);
            } else if (linkNodes.get(i) == node && i + 1 == linkNodes.size()) {
                return null;
            }
        }
        return null;
    }

    private void zhongxubianli(TreeLinkNode temp) {
        if (temp == null
        ) {
            return;
        }
        zhongxubianli(temp.left);
        linkNodes.add(temp);
        zhongxubianli(temp.right);
    }

    private void zhongxutwo(TreeLinkNode temp) {
        if (temp == null
        ) {
            return;
        }
        Stack<TreeLinkNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            TreeLinkNode node = stack.pop();
            linkNodes.add(node);
            temp = node.right;
        }
    }

}

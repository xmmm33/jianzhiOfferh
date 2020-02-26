package day2.time_0226_0945;

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
 *
 */
public class VerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length < 1) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int root = sequence[sequence.length - 1];
        int index = -1;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > root) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return true;
        }
        for (int i = index; i < sequence.length; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        boolean left = VerifySquenceOfBST(Arrays.copyOf(sequence, index+1));
        boolean right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length-1));
        return left && right;
    }

    public static void main(String[] args) {
        if (VerifySquenceOfBST(new int[]{5, 4, 3, 2, 1})) {
            System.out.println("tttt");
        }
    }
}

package day1.time_0209_2009;

import java.util.Stack;

/**
 * 栈的压入顺序和弹出顺序
 * 输入一个栈的压入顺序，假设所有数值不相等
 * 判断一个序列是否可能为弹出顺序。
 */
public class StackInAndOut {


    private static Stack<Integer> stack = new Stack<>();

    /**
     * 假设pushA为1,2,3,4,5 popA为4,5,3,2,1
     * 此时来一个stack栈，把1压入stack，然后比较stack的栈顶元素是否等于popA[index]
     * 如果相等，说明需要弹出，弹出之后需要循环判断，
     * 比如当4压入stack的时候，发现stack.peek等于popA[index],然后就stack.pop();弹出之后，需要继续判断3是否等于弹出序列的下一个值，如果是，就继续弹出，如果不是，就压入stack元素。
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length <= 0 || pushA.length != popA.length) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 这个while循环要体会一下，
            // 当碰到stack栈顶的元素等于弹出序列popA的对应的值的时候，就需要弹出栈了，弹出栈之后还需要继续判断后面的是否需要继续弹出
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1}, new int[]{1});
    }
}

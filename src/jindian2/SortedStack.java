package jindian2;

import java.util.Stack;

public class SortedStack {


    private Stack<Integer> stack;

    private Stack<Integer> temp;

    // 栈排序
    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        if (!stack.isEmpty()) {
            while (!stack.isEmpty() && val > stack.peek()) {
                temp.push(stack.pop());
            }
            stack.push(val);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }else {
            stack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

package jindian2;

import java.util.Stack;

public class MinStack {


    private Stack<Integer> stack;

    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!min.isEmpty()) {
            if (x <= min.peek()) {
                min.push(x);
            }
        }else {
            min.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }else {
            return -1;
        }
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }else {
            return -1;
        }
    }
}

package day1.time_0209_2009;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!min.isEmpty()) {
            if (min.peek() > node) {
                min.push(node);
            }else if (min.peek().equals(node)){
                min.push(min.peek());
            }
        }
        else {
            min.push(node);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {

        }else {
            if (stack.peek().equals(min.peek())) {
                min.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return new Integer(null);
        }
    }
}

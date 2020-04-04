package LeetCode2;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> instack;
    private Stack<Integer> minstack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        instack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        instack.push(x);
        if (!minstack.isEmpty()) {
            if (minstack.peek() > x) {
                minstack.push(x);
            } else if (minstack.peek().equals(x)) {
                minstack.push(minstack.peek());
            }
        }else {
            minstack.push(x);
        }
    }

    public void pop() {
        if (!instack.isEmpty()) {
            if (instack.peek().equals(minstack.peek())) {
                minstack.pop();
            }
            instack.pop();
        }
    }

    public int top() {
        return instack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

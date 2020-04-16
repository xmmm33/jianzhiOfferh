package jianzhiOffer2;

import java.util.Stack;

public class MinStack {


    private Stack<Integer> in;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        in = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
        if (!min.isEmpty()) {
            if (x <= min.peek()) {
                min.push(x);
            }
        }else {
            min.push(x);
        }
    }

    public void pop() {
        int val = in.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return in.peek();
    }

    public int min() {
        if (!min.isEmpty()) {
            return min.peek();
        }else {
            return new Integer(null);
        }
    }
}

package jindian2;

import java.util.Stack;

public class MyQueue {

    // 用栈实现队列

    private Stack<Integer> in;

    private Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!out.isEmpty()) {
            return out.pop();
        }else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!out.isEmpty()) {
            return out.peek();
        }else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

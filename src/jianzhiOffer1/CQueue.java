package jianzhiOffer1;

import java.util.Stack;

public class CQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;
    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
            return out.pop();
        }else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            if (!out.isEmpty()) {
                return out.pop();
            }else {
                return -1;
            }
        }
    }
}

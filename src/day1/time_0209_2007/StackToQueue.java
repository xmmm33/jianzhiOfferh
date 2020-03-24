package day1.time_0209_2007;

import java.util.Stack;

public class StackToQueue {

    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();

    public static void offer(int a) {
        in.push(a);
    }

    public static int poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        offer(1);
        offer(2);
        System.out.println(poll());
        System.out.println(poll());
    }
}

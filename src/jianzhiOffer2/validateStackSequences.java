package jianzhiOffer2;

import java.util.Stack;

public class validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length < 1) {
            return true;
        }
        int k = 0;
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[k]) {
                temp.push(pushed[i]);
            }else {
                k++;
                while (!temp.isEmpty() && temp.peek() == popped[k]) {
                    temp.pop();
                    k++;
                }
            }
        }
        while (k < popped.length && temp.peek() == popped[k]) {
            temp.pop();
            k++;
        }
        return temp.isEmpty();
    }
}

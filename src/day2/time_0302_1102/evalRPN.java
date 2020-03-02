package day2.time_0302_1102;

import java.util.Stack;

/**
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class evalRPN {

    public int evalRPN(String[] tokens) {
        if(tokens.length < 1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (i == 0) {
                stack.push(Integer.valueOf(tokens[i]));
            }
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = b + a;
                stack.push(res);
                continue;
            }
            if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = b - a;
                stack.push(res);
                continue;
            }
            if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = b * a;
                stack.push(res);
                continue;
            }
            if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = b / a;
                stack.push(res);
                continue;
            }
            stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}

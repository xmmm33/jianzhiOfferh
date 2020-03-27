package leetcode;


import java.util.Stack;

/**
 * 最长括号
 */
public class longestValidParentheses {


    public static int longestValidParentheses(String s) {
        Stack<Integer> res = new Stack<>();
        int max = 0;
        res.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res.push(i);
            }else {
                res.pop();
                if (res.isEmpty()) {
                    res.push(i);
                }else {
                    max = Math.max(max, i - res.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}

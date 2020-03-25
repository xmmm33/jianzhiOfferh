package leetcode;

import java.util.Stack;

public class isValid {

    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        if (s.length() < 1) {
            return true;
        }
        if (s.startsWith("]") || s.startsWith("}") || s.startsWith(")")) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (res.isEmpty()) {
                res.push(chars[i]);
            }else {
                if (chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                    char temp = res.peek();
                    if (ispipei(temp, chars[i])) {
                        res.pop();
                    }else {
                        return false;
                    }
                }else {
                    res.push(chars[i]);
                }
            }
        }
        if (res.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    private boolean ispipei(char temp, char aChar) {
        if (temp == '[' && aChar == ']') {
            return true;
        }
        if (temp == '{' && aChar == '}') {
            return true;
        }
        if (temp == '(' && aChar == ')') {
            return true;
        }
        return false;
    }
}

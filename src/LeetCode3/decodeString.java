package LeetCode3;

import java.util.LinkedList;

public class decodeString {

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 存放字符出现的次数
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 存放上一个字符
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curmulti = stack_multi.removeLast();
                for (int i = 0; i < curmulti; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = Integer.parseInt(c + "");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }
}

package jindian5;

import java.util.ArrayList;
import java.util.List;

public class permutation {


    private static List<String> res = new ArrayList<>();
    // 全排列 不能使用重复的元素
    public static String[] permutation(String S) {
        char[] s = S.toCharArray();
        boolean[] visited = new boolean[s.length];
        backtrace(s, visited, new StringBuilder());
        return res.toArray(new String[0]);
    }

    private static void backtrace(char[] s, boolean[] visited, StringBuilder stringBuilder) {
        if (stringBuilder.length() == s.length) {
            res.add(stringBuilder.toString());
        }
        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            stringBuilder.append(s[i]);
            backtrace(s, visited, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        permutation("ab");
    }
}

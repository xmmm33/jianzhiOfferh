package jindian5;

import java.util.HashSet;
import java.util.Set;

public class permutation2 {

    private Set<String> res = new HashSet<>();
    // 全排列 原字符串中有重复的字符 就是res使用的不一样
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] visited = new boolean[chars.length];
        backtrace(chars, new StringBuilder(),visited);
        return res.toArray(new String[0]);
    }

    private void backtrace(char[] chars, StringBuilder stringBuilder, boolean[] visited) {
        if (stringBuilder.length() == chars.length) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            stringBuilder.append(chars[i]);
            backtrace(chars, stringBuilder, visited);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;
        }
    }
}

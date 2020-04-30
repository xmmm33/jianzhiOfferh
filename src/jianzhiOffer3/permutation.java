package jianzhiOffer3;


import java.util.HashSet;
import java.util.Set;

/**
 * 字符串排列
 */
public class permutation {


    static Set<String> res = new HashSet<>();
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        // 标记某个字符是否被使用过
        boolean[] vis = new boolean[chars.length];
        dfs(chars, vis,new StringBuilder());
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(char[] chars, boolean[] vis, StringBuilder path) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.append(chars[i]);
            dfs(chars, vis, path);
            path.deleteCharAt(path.length() - 1);
            vis[i] = false;
        }
        return;
    }

}

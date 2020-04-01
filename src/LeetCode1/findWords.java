package LeetCode1;

import java.util.ArrayList;
import java.util.List;

public class findWords {

    boolean flag = false;

    /**
     * 字符搜索II
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length < 1 || board[0].length < 1) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            if (exist(board, temp)) {
                res.add(temp);
            }
        }
        return res;
    }

    public boolean exist(char[][] board, String words) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    flag = false;
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int j, int k, String temp, int curlen) {
        if (curlen == temp.length()) {
            flag = true;
            return true;
        }
        if (j < 0 || j >= board.length || k < 0 || k >= board[0].length || board[j][k] != temp.charAt(curlen)) {
            return false;
        }
        if (!flag) {
            char c = board[j][k];
            // 防止当前字符被重复使用
            board[j][k] = '.';
            boolean res1 = dfs(board, j + 1, k, temp, curlen + 1);
            boolean res2 = dfs(board, j - 1, k, temp, curlen + 1);
            boolean res3 = dfs(board, j, k + 1, temp, curlen + 1);
            boolean res4 = dfs(board, j, k - 1, temp, curlen + 1);
            board[j][k] = c;
            return res1 || res2 || res3 || res4;
        }else {
            return true;
        }
    }
}

package LeetCode1;

public class exist {

    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int curlen) {
        if (curlen == word.length()) {
            flag = true;
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(curlen)) {
            return false;
        }
        // 没有找到解 继续找
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '.';
            boolean res1 = dfs(board, i + 1, j, word, curlen + 1);
            boolean res2 = dfs(board, i - 1, j, word, curlen + 1);
            boolean res3 = dfs(board, i, j + 1, word, curlen + 1);
            boolean res4 = dfs(board, i, j - 1, word, curlen + 1);
            board[i][j] = c;
            return res1 || res2 || res3 || res4;
        } else {
            return true;
        }
    }
}

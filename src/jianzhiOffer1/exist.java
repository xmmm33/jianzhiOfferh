package jianzhiOffer1;

public class exist {

    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int curlen) {
        if (curlen == word.length()) {
            flag = true;
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(curlen)) {
            return false;
        }
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '.';
            boolean res1 = dfs(board, word, i - 1, j, curlen + 1);
            boolean res2 = dfs(board, word, i + 1, j, curlen + 1);
            boolean res3 = dfs(board, word, i, j-1, curlen + 1);
            boolean res4 = dfs(board, word, i , j+1, curlen + 1);
            board[i][j] = c;
            return res1 || res2 || res3 || res4;
        }else {
            return true;
        }
    }
}

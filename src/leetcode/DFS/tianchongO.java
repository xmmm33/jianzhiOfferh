package leetcode.DFS;


/**
 * 填充被包起来的O，
 */
public class tianchongO {

    /**
     * 任何不在边界上的O，或 不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 该题就需要找到边界上的O或者与边界连通的O
     */
    int row,col;
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        row = board.length;
        col = board[0].length;
        //对第一行和最后一行的所有O进行深度优先搜索
        for (int i = 0; i < row; i++) {
            dfs(board,i, 0);
            dfs(board, i, col - 1);
        }
        //对第一列和最后一列的所有O进行深度优先搜索
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        //遍历矩阵，将O变为X，将-变为O
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        return ;
    }

    /**
     * 使用递归进行深度优先搜索
     */
    public void dfs(char[][] board,int i,int j){
        //递归终止条件判断
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')
            return;
        //将当前O更改为-
        board[i][j]='-';
        //递归该点上方的点
        dfs(board,i-1,j);
        //递归该点下方的点
        dfs(board,i+1,j);
        //递归该点左边的点
        dfs(board,i,j-1);
        //递归该点右边的点
        dfs(board,i,j+1);
        return ;
    }
}

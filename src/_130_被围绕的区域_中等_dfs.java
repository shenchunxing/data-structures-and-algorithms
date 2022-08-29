/**
 * https://leetcode.cn/problems/surrounded-regions/
 */
public class _130_被围绕的区域_中等_dfs {
    //任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。
    // 我们可以利用这个性质判断 O 是否在边界上
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        //因为第0列和第col -1 列是不会被填充的，遍历查找不会被填充的字母o
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col - 1);
        }
        //因为第0行和第row -1 行是不会被填充的，遍历查找不会被填充的字母o
        for (int i = 0; i < col; i++) {
            dfs(board,0,i );
            dfs(board,row - 1,i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A' ) {//如果被访问过，说明不是被包围的，还原成'O'
                    board[i][j] = 'O';
                } else {//没有访问到的'O',说明是被包围的，替换成'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row <0 || row >= board.length) return;
        if (col <0 || col >= board[0].length) return;
        if (board[row][col] != 'O') return;
        board[row][col] = 'A'; //被访问了
        dfs(board,row,col + 1);
        dfs(board,row,col - 1);
        dfs(board,row + 1,col);
        dfs(board,row - 1,col);
    }
}

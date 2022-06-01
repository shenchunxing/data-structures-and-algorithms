/**
 * https://leetcode.cn/problems/surrounded-regions/
 */
public class _130_被围绕的区域 {
    //任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。
    // 我们可以利用这个性质判断 O 是否在边界上
    public void solve(char[][] board) {
        int row = board.length , col = board[0].length;
        if (row == 0) return;
        //因为第0列和第col -1 列是不会被填充的，遍历查找不会被填充的字母o
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col - 1);
        }
        //因为第0行和第row -1 行是不会被填充的，遍历查找不会被填充的字母o
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row - 1,i);
        }

        //分析遍历结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') { //如果被访问过，说明不是被包围的，还原成'O'
                    board[i][j] = 'O';
                } else if ( board[i][j] == 'O') { //没有访问到的'O',说明是被包围的，替换成'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 四个方向dfs
     * @param board
     * @param row
     * @param col
     */
    private void dfs(char[][] board , int row , int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (board[row][col] != 'O') return; //访问的不是'o，直接返回
        board[row][col] = 'A';
        dfs(board,row + 1,col);
        dfs(board,row - 1,col);
        dfs(board,row,col + 1);
        dfs(board,row,col - 1);
    }
}

package DFS;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/surrounded-regions/
 * 难度：中等
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
/*2023-7-11*/
public class _130_被围绕的区域 {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };

        solve(board);

        //打印输出的二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。
     * 我们可以利用这个性质判断 O 是否在边界上
     */
    static public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        /*行和列*/
        int row = board.length, col = board[0].length;
        //因为第0列和第col -1 列是不会被填充的，遍历查找不会被填充的字母O。
        /*从第i行，第0列开始查找*/
        /*从第i行，第col - 1列开始查找*/
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col - 1);
        }
        //因为第0行和第row -1 行是不会被填充的，遍历查找不会被填充的字母o
        /*从第i列，第0列开始查找*/
        /*从第i列，第row - 1列开始查找*/
        for (int i = 0; i < col; i++) {
            dfs(board,0,i );
            dfs(board,row - 1,i);
        }

        //已经查找完毕。根据O是否被访问过，填充'X'
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

    /**
     * 在二维数组board中，从row行，clol列的位置开始查找'O'
     */
    static private void dfs(char[][] board, int row, int col) {
        //已经越界了，直接return
        if (row <0 || row >= board.length) return;
        if (col <0 || col >= board[0].length) return;
        //不是O的也没必须要访问（如果是A说明被访问过了，如果是X则没必须继续下去搜索了）
        if (board[row][col] != 'O') return;
        board[row][col] = 'A'; //O被访问了，替换成'A'，标记下
        /*从上下左右4个方向继续查找*/
        dfs(board,row,col + 1);
        dfs(board,row,col - 1);
        dfs(board,row + 1,col);
        dfs(board,row - 1,col);
    }
}

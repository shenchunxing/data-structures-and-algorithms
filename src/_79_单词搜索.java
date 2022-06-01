/**
 * https://leetcode.cn/problems/word-search/
 */
public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果发现匹配到了字符，则继续深入查找
               if (dfs(board,word, 0,i,j)) return true;
            }
        }
        return false;
    }

    /**
     * 上下左右4个方向查找
     * @param board
     * @param word
     * @param index
     * @param i
     * @param j
     * @return
     */
    private boolean dfs(char[][] board, String word ,int index , int i , int j) {
        //边界
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return false;
        if (board[i][j] == '.' || board[i][j] != word.charAt(index)) return false;
        if (word.length() - 1 == index) return true;

        //原地修改数组的值
        char temp = board[i][j];
        board[i][j] = '.';
        //上下左右4个方向查找
        boolean b1 = dfs(board,word,index + 1,i + 1,j);
        boolean b2 = dfs(board,word,index + 1,i - 1,j);
        boolean b3 = dfs(board,word,index + 1,i,j + 1);
        boolean b4 = dfs(board,word,index + 1,i,j - 1);
        board[i][j] = temp; //回溯
        return b1 || b2 || b3 || b4;
    }
}

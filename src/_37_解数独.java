import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sudoku-solver/
 */
public class _37_解数独 {
    private boolean[][] line = new boolean[9][9];//保存行数字填入情况
    private boolean[][] column = new boolean[9][9];//保存列数字填入情况
    private boolean[][][] block = new boolean[3][3][9];//保存3*3数字填入情况
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>(); //统计可填入空格的位置

    //dfs
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') { //如果是空格，统计可填入空格的位置
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1; //如果是数字。行、列、3*3都设置为true
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) { //边界
            valid = true;
            return;
        }

        int[] space = spaces.get(pos); //当前层可填入的空格
        int i = space[0], j = space[1];//空格的位置
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //已经填入的过了，直接过滤
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                //已经遍历过了，设置为true
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                //填入数字
                board[i][j] = (char) (digit + '0' + 1);
                //进入下一层
                dfs(board, pos + 1);
                //回溯
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}

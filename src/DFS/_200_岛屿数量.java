package DFS;

/**
 * https://leetcode.cn/problems/number-of-islands/
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { //如果是岛屿
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid , int row , int col) {
        //边界过滤
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        //去重
        if (grid[row][col] == '0') return;

        grid[row][col] = '0';//访问过了
        dfs(grid,row,col -1);
        dfs(grid,row + 1,col);
        dfs(grid,row - 1,col);
        dfs(grid,row,col + 1);
    }
}

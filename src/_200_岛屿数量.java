/**
 * https://leetcode.cn/problems/number-of-islands/
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int num_island = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') { //如果是岛屿
                    num_island++; //岛屿数量+1
                    dfs(grid,row,col);//继续朝内部遍历
                }
            }
        }
        return num_island;
    }

    private void dfs(char[][] grid , int row , int col) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == '0') return;
        grid[row][col] = '0' ; //遍历过的位置，设为0
        //4个方向去遍历
        dfs(grid,row - 1,col);
        dfs(grid,row,col - 1);
        dfs(grid,row,col + 1);
        dfs(grid,row + 1,col);
    }
}

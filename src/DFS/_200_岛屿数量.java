package DFS;

/**
 * https://leetcode.cn/problems/number-of-islands/
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
/*2023-7-11*/
public class _200_岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int numIslands = numIslands(grid);
        System.out.println("Number of Islands: " + numIslands); //3
    }

    static public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { //如果发现了陆地，需要深入进去
                    num++;//发现陆地，岛屿++
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    static private void dfs(char[][] grid , int row , int col) {
        //边界过滤
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        //遇到了水，直接返回
        if (grid[row][col] == '0') return;

        grid[row][col] = '0';//访问过了该陆地，变成水。防止下次重复访问
        /*从该陆地上下左右去深入，继续寻找陆地*/
        dfs(grid,row,col -1);
        dfs(grid,row + 1,col);
        dfs(grid,row - 1,col);
        dfs(grid,row,col + 1);
    }
}

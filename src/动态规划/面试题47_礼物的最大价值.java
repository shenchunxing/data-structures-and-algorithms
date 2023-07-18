package 动态规划;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
/*2023-7-18*/
public class 面试题47_礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        System.out.println(maxValue(grid));
    }
    static public int maxValue(int[][] grid) {
    	int rows = grid.length , cols = grid[0].length;
        /*注意：创建的数组大小和逻辑有关，有时候需要 + 1,有时候不需要，此处因为之和前一个网格有关。不需要 + 1*/
        int[][] dp = new int[rows][cols];
        /*第0行0列的值就是该位置的价值*/
        dp[0][0] = grid[0][0];
        /*第0列：一直往下走*/
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        /*第0行：一直往右走*/
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j -1] + grid[0][j];
        }
        /*其他行*/
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                //较大的值+当前格子的值
                dp[row][col] = Math.max(dp[row - 1][col],dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

package 动态规划;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 
 * @author MJ
 *
 */
public class 面试题47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
    	int rows = grid.length , cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) { //第0列
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) { //第0行
            dp[0][j] = dp[0][j -1] + grid[0][j];
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                //较大的值+当前格子的值
                dp[row][col] = Math.max(dp[row - 1][col],dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

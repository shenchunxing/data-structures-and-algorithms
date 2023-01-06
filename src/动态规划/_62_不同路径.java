package 动态规划;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 
 * @author MJ
 *
 */
public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) { //第0列
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {//第0行
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j -1]; //最后一步从上面下来或从左进来
			}
		}
		return dp[m - 1][n - 1];
    }
}

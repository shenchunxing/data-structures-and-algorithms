package 动态规划;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
/*2023-7-6*/
public class _62_不同路径 {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,7));
	}

    static public int uniquePaths(int m, int n) {
		/*dp[i]表示，在i的位置有多少种不同路径*/
		int[][] dp = new int[m][n];
		/*获取边界值*/
		for (int i = 0; i < m; i++) { //第0列一直向下，只有1条路径
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {//第0行一直向右，只有1条路径
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				/*[i,j]所处的位置由[i-1,j]或者[i,j -1]而来*/
				dp[i][j] = dp[i - 1][j] + dp[i][j -1];
			}
		}
		/*因为是位置，默认从0开始，所以是dp[m - 1][n - 1]*/
		return dp[m - 1][n - 1];
    }
}

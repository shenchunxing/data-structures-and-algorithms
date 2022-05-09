
/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @author shenchunxing
 *
 */
public class _63_不同路径II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int n = obstacleGrid.length , m = obstacleGrid[0].length;
		
		int[] f = new int[m];
		
		f[0] = obstacleGrid[0][0] == 0 ? 1: 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				if (obstacleGrid[i][j] == 1) { //有障碍物，路径总数为0
					f[j] = 0;
					continue;
				}
				
				//上一个网格没有障碍物 && 上一个网格不在边上
				if (j - 1 > 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] = f[j] + f[j - 1];
				}
			}
			
		}
		return f[m - 1];
    }
	
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        //初始化第一列，只要碰到1，后面都无法到达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1; //不是障碍物，新增一个路径
        }
        //初始化第一行，只要碰到1，后面都无法到达
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;//不是障碍物，新增一个路径
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //自动跳过路障
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}


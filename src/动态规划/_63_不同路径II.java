package 动态规划;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
/*2023-7-6*/
public class _63_不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }

    /*优化成一维数组*/
	static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length , n = obstacleGrid[0].length;
        /*f存储每个位置的路径数量*/
		int[] f = new int[n];
        /*设置初始值，有可能起点位置就是障碍物的情况*/
		f[0] = obstacleGrid[0][0] == 0 ? 1: 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j <n; j++) {
				if (obstacleGrid[i][j] == 1) { //有障碍物，当前位置的路径总数为0
					f[j] = 0;
					continue;
				}
				
				//如果上一个位置不是障碍物，j - 1 >= 0是为了确保obstacleGrid[i][j - 1]有效性
                //这是因为从上一个位置到达当前位置的路径数量为 f[j] + f[j - 1]，相当于将路径从上方f[j]或左侧f[j - 1]延伸到当前位置
				if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] = f[j] + f[j - 1];
				}
			}
			
		}
		return f[n - 1];
    }
	
	static public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        /*和不同路径那题的区别就是初始值不同，循环过程中需要跳过障碍物*/
        /*初始值：如果第0列有障碍物，则障碍物之后的位置都不可达。障碍物之前的位置只有一种路径就是一直往下走*/
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break; // i后面的位置都不可达
            dp[i][0] = 1;
        }
        /*初始值：如果第0行有障碍物，则障碍物之后的位置都不可达。障碍物之前的位置只有一种路径就是一直往右走*/
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;// i后面的位置都不可达
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue; //遇到障碍物，跳过，从其他方向走
                /*[i,j]所处的位置由[i-1,j]或者[i,j -1]而来*/
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}


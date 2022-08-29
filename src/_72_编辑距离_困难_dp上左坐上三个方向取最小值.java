/**
 * https://leetcode-cn.com/problems/edit-distance/
 * @author MJ Lee
 *
 */
public class _72_编辑距离_困难_dp上左坐上三个方向取最小值 {
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return 0;
    	char[] cs1 = word1.toCharArray();
    	char[] cs2 = word2.toCharArray();
    	int[][] dp = new int[cs1.length + 1][cs2.length + 1];
    	dp[0][0] = 0;
    	// 第0列
    	for (int i = 1; i <= cs1.length; i++) {
			dp[i][0] = i;
		}
    	// 第0行
    	for (int j = 1; j <= cs2.length; j++) {
			dp[0][j] = j;
		}
    	// 其他行其他列
    	for (int i = 1; i <= cs1.length; i++) {
			for (int j = 1; j <= cs2.length; j++) {
				int top = dp[i - 1][j] + 1; //上面
				int left = dp[i][j - 1] + 1;//左边
				int leftTop = dp[i - 1][j - 1]; //左上角
				if (cs1[i - 1] != cs2[j - 1]) {//最后一个元素不相等,需要加一步替换操作
					leftTop++;
				}
				dp[i][j] = Math.min(Math.min(top, left), leftTop);//取三者最小值
			}
		}
    	return dp[cs1.length][cs2.length];
    }
}

package 动态规划;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 难度：困难
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 思路：动态规划
 */
/*2023-7-18*/
public class _72_编辑距离 {
	public static void main(String[] args) {
		System.out.println(minDistance("horse","ros"));
		System.out.println(minDistance("intention","execution"));
	}
    static public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return 0;
    	char[] cs1 = word1.toCharArray();
    	char[] cs2 = word2.toCharArray();
		//dp[i,j]表示cs1[0,i)转换成cs2[0,j)需要的最少操作数
    	int[][] dp = new int[cs1.length + 1][cs2.length + 1];
    	dp[0][0] = 0;
    	/*第0行和第0列只能依次插入字符*/
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
				/**
				 * 3种情况； 已知cs1[i - 1]转成cs2[j]的操作数，给cs1添加一个操作，就能得到cs[i][j]的操作数
				 *          已知cs1[i]转成cs2[j - 1]的操作数，给cs2添加一个操作，就能得到cs[i][j]的操作数
				 *          已知cs1[i - 1]转成cs2[j - 1]的操作数，如果cs1[i - 1] != cs2[j - 1]，则给cs1替换一个操作，就能得到cs[i][j]的操作数
				 */
				int top = dp[i - 1][j] + 1; //上面，先删除cs1最后一个字符，得到cs1[0,i -1)，再转成cs2[0,j)
				int left = dp[i][j - 1] + 1;//左边
				int leftTop = dp[i - 1][j - 1]; //左上角
				/*左上角的情况，如果最后一个元素不相等,需要加一步替换操作*/
				if (cs1[i - 1] != cs2[j - 1]) {
					leftTop++;
				}
				dp[i][j] = Math.min(Math.min(top, left), leftTop);//取三者最小值
			}
		}
    	return dp[cs1.length][cs2.length];
    }
}

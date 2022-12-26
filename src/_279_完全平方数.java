/**
 * https://leetcode.cn/problems/perfect-squares/
 */
public class _279_完全平方数 {
    public static void main(String[] args) {
       System.out.println(numSquares(13));
       System.out.println(numSquares(12));
    }
    static public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            dp[i] = i;//默认每次都选1，1^2 = 1，求和得到i
            for (int j = 1; i - j * j >= 0; j++) { //当前i的最大平方根是根号i，即i - j * j >= 0
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);//选了j，总和减去j^2，数量需要加1，dp[i - j * j] + 1
            }
        }
        return dp[n];
    }
}

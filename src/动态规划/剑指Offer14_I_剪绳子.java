package 动态规划;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 */
public class 剑指Offer14_I_剪绳子 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(8));
    }
    static public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //长度的一半作为边界
        for (int i = 0; i <= (n + 1) >> 1; i++) {
            for (int j = i; j <= n ; j++) {
                //绳子长度为j时，当前截取i长度的绳子,可以获取的最大乘积
                dp[j] = Math.max(dp[j],dp[j - i] * i);
            }
        }
        return dp[n];
    }
}

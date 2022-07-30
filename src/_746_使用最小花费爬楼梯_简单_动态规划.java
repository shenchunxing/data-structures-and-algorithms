/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class _746_使用最小花费爬楼梯_简单_动态规划 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0; //可以从0或者1开始
        for (int i = 2; i <= n; i++) {
            //最后一步可以选择走一步还是两步
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}

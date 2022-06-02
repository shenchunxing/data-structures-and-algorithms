import java.util.function.Predicate;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）
 *   卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
 *   注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class _309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];//dp[i][j]表示第i天结束后的最大收益
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // dp[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        dp[0][0] = -prices[0];//第一天手上持有股票，说明是第一天买入的，收益为负数
        for (int i = 1; i < n; i++) {
            //手上持有股票，则前一天可能已经持有dp[i - 1][0]。或者是第i天买入的。那么第i-1天就不能为冷冻期dp[i - 1][2] - prices[i]
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][2] - prices[i]);
            //手上不持有股票,且是冷冻期，说明i- 1天持有股票，i天卖出了。收益是prices[i]
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 手上不持有股票,且不是冷冻期，说明当天没有任何操作。说明第i - 1天不持有股票
            // 如果i - 1天是冷冻期，则dp[i - 1][1]
            // 如果i - 1天不是冷冻期，则dp[i - 1][2]
            dp[i][2] = Math.max(dp[i - 1][1],dp[i - 1][2]);
        }
        //dp[n - 1][0]可以排除，因为不可能在最后去持有股票
//        return Math.max(Math.max(dp[n - 1][0],dp[n - 1][1]),dp[n - 1][2]);
        return Math.max(dp[n - 1][2],dp[n - 1][1]);
    }

    /**
     * 空间优化：dp[i]只和前一天有关系，可以继续优化
     */
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int dp0 = -prices[0], dp1 = 0 , dp2 = 0;
        for (int i = 1; i < n; i++) {
            int new_dp0 = Math.max(dp0 , dp2 - prices[i]);
            int new_dp1 = dp0 + prices[i];
            int new_dp2 = Math.max(dp1 , dp2);

            dp0 = new_dp0;
            dp1 = new_dp1;
            dp2 = new_dp2;
        }
       return Math.max(dp1,dp2);
    }
}

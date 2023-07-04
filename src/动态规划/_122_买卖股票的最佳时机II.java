package 动态规划;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class _122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
    /**
     * 这题最佳算法为贪心算法O(n)：没有交易次数限制，每次涨的前一天买入，下一天卖出，每次都有获利
     */
   static public int maxProfit(int[] prices) {
         int n = prices.length;
         int ans = 0;
        for (int i = 1; i < n; i++) {
            //每次涨的前一天买入，下一天卖出，每次都有获利，
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    /**
     * 每一天的状态只和前一天有关，优化成一维数组
     */
    static public int maxProfit3(int[] prices) {
        int n = prices.length;
        //dp0:第i天没有持有股票的最大利润
        //dp1:第i天持有股票的最大利润
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0 = Math.max(dp0,dp1 + prices[i]);//需要不持有股票，dp1是持有股票的，需要卖出股票获取利润 + price[i]
            dp1 = Math.max(dp1,dp0 - prices[i]);//需要持有股票，dp0是没有持有的，需要买进股票- price[i]
        }
        return dp0;
    }

    /**
     * 动态规划：dp[i][0]表示第i天交易完没有股票的最大利润，dp[i][1]表示第i天交易完持有股票的最大利润，
     */
    static public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; //没有持有股票，利润为0，
        dp[0][1] = -prices[0];//持有股票，也就是买了一只股票，利润为负数
        for (int i = 1; i < n; i++) {
            //当前i天没有持有股票，可能前一天持有股票，今天卖出了，也可能前一天也没有股票
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][0]);
            //当前i天持有股票，可能前一天就持有股票，也可能前一天没有，今天买入了
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][1] - prices[i]);
        }
        /*返回第n天交易完，手上没有股票的最大利润*/
        return dp[n - 1][0];
    }

}

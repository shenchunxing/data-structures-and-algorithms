/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class _122_买卖股票的最佳时机II_中等_动态规划 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
    /**
     * 贪心：没有交易次数限制，每次涨的前一天买入，下一天卖出，每次都有获利
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
        dp[0][1] = -prices[0];//买了一只股票，利润为负数
        for (int i = 1; i < n; i++) {
            //当前i天没有持有股票，可能前一天持有股票，今天卖出了，也可能前一天也没有股票
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            //当前i天持有股票，可能前一天持有股票，今天卖出了，也可能前一天也没有，今天买入了
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][1] - prices[i]);
        }
        return dp[n - 1][0];
    }

}

package 动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
/*2023-7-4*/
public class _121_买卖股票的最佳时机 {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
	}

   static public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
		int maxProfit = 0; //最大利润
		int minPrice = prices[0]; //最小价格
		for (int i = 0; i < prices.length; i++) {
			/*发现更小的值，作为买入值*/
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else  {
				/*否则，更新利润最大值*/
				maxProfit = Math.max(maxProfit,prices[i] - minPrice);
			}
		}
		return maxProfit;
    }
}



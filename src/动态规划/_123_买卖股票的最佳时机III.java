package 动态规划;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

/*2023-7-4*/
public class _123_买卖股票的最佳时机III {
    public static void main(String[] args) {
        /*在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 */
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
    static public int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * 任何时候，总是处于以下几种状态之一：
         *   未进行任何操作，利润为0，可以不处理
         *   buy1：只进行过1次买操作
         *   sel11：进行了一次买操作和一次卖操作，即完成了一次交易
         *   buy2：在完成一次交易的前提下，进行了第二次买操作
         *   sell2：完成了二次交易
         */
        //默认买入的股票是第1支股票，buy1 = buy2 = -prices[0]，默认利润为0。sel11 = sel12 = 0
        int buy1 = -prices[0], sel11 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1,-prices[i]); //默认买入第一个，比较当前i，得到最低的买入价
            sel11 = Math.max(sel11,buy1 + prices[i]);//默认利润为0，比较当前i，得到最高的利润 = 当前价格 - 最低买入价
            buy2 = Math.max(buy2,sel11-prices[i]);
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }
        return sell2;
    }
}

package 动态规划;

/**
 * https://leetcode.cn/problems/coin-change-2/
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 */
public class _518_零钱兑换II {
    public static void main(String[] args) {
        _518_零钱兑换II o = new _518_零钱兑换II();
        System.out.println(o.change(5,new int[] {1,2,5}));
    }
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];//dp[i]表示凑够i需要的硬币数
        dp[0] = 1;//只有当不选取任何硬币时，金额之和才为0，因此只有1 种硬币组合
        for (int coin : coins) {
            //对于每一种硬币，coin<= i <= amount,如果存在i - coin，则只需要加上一个面值为coin的就可以得到一种组合
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] > 0) { //存在一种解
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}

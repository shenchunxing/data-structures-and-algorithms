package 动态规划;

/**
 * https://leetcode.cn/problems/perfect-squares/
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
/*2023-7-18*/
public class _279_完全平方数 {
    public static void main(String[] args) {
       System.out.println(numSquares(13));//2^2 + 3^2
       System.out.println(numSquares(12));//1^1 + 2^2 + 2^2
       System.out.println(numSquares(3));//1^1 + 1^1 + 1^1
       System.out.println(numSquares(4));//2^2
    }
    static public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            /*这种情况是最多的，也就是全部都是1的平方组成*/
            dp[i] = i;
            /*当前i的最大平方根是根号i，即i - j * j >= 0*/
            for (int j = 1; i - j * j >= 0; j++) {
                /*当前数字i的最小平方数之和*/
                /*dp[i - j * j] + 1的含义：选了j，数量需要加1，剩余的总是就是dp[i - j * j]*/
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

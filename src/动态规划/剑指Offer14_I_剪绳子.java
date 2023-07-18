package 动态规划;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
/*2023-7-18*/
public class 剑指Offer14_I_剪绳子 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(8));
    }
    /*时间复杂度O(n^2)*/
    static public int cuttingRope(int n) {
        /*存储每个绳子长度下的最大乘积*/
        int[] dp = new int[n + 1];
        /*特殊值：绳子长度为0，得到的乘积1，特殊值有时候不确定，可以在最后写，题目中内层循环会用到dp[j]，j = 0的时候，就知道默认dp[0]需要等于1*/
        dp[0] = 1;
        //长度的一半作为边界
        /*外层循环表示截取的绳子长度 i*/
        for (int i = 0; i <= (n + 1) >> 1; i++) {
            /*内层循环表示当前绳子的总长度j，由于对称性，只需遍历长度范围 i 到 n*/
            for (int j = i; j <= n ; j++) {
                //绳子长度为j时，当前截取i长度的绳子,可以获取的最大乘积 = 剩余长度的最大乘积dp[j - i] * 当前截去长度i
                dp[j] = Math.max(dp[j],dp[j - i] * i);
            }
        }
        return dp[n];
    }
}

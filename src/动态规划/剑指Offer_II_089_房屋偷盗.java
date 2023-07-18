package 动态规划;

/**
 * https://leetcode.cn/problems/Gu0c2T/
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums，请计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
/*2023-7-18*/
public class 剑指Offer_II_089_房屋偷盗 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,7,9,3,1}));
    }
    static public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len]; //dp[i]表示偷窃到第i间房子可以获取到的最大金额
        if (len == 1) return nums[0];
        /*前两个房间的值*/
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            /*比较当期房间偷窃和不偷窃的情况下获取的较大值*/
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}

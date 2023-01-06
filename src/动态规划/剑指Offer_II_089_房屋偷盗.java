package 动态规划;

/**
 * https://leetcode.cn/problems/Gu0c2T/
 */
public class 剑指Offer_II_089_房屋偷盗 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[nums.length]; //dp[i]表示偷窃到第i间房子可以获取到的最大金额
        if (len == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}

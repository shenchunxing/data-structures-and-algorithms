package 动态规划;

/**
 * https://leetcode.cn/problems/house-robber/
 */
public class _198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];

        int[] dp = new int[length];
        dp[0] = nums[0];//dp[i]表示偷窃i间房屋，可以获取的最大金额
        dp[1] = Math.max(nums[0],nums[1]);
        //偷窃第k间房屋，那么就不能偷窃第k−1间房屋，偷窃金额为第k-2间房屋的金额 + 第i间房屋的金额
        //偷窃第k - 1间房屋，那么就不能偷窃第k间房屋，偷窃金额为第k-1间房屋的金额
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i -1] ,dp[i - 2] + nums[i]);
        }
        return dp[length  - 1];
    }
}

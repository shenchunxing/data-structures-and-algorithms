package 动态规划;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class _300_最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));//{2,3,7,101}
    }
    static public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; //dp[i]以i结尾的最长上升子序列的长度
        int max = dp[0] = 1;//默认第一个
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;//最长上升子序列的长度，至少为1，就是自己
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //处于上升中
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]); //每一轮取得最大的长度
        }
        return max;
    }
}

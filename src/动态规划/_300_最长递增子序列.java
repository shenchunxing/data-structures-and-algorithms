package 动态规划;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
/*2023-7-18*/
public class _300_最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));//{2,3,7,101}
    }
    static public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; //dp[i]以i结尾的最长上升子序列的长度
        int max = dp[0] = 1;//默认第一个
        for (int i = 1; i < dp.length; i++) {
            /*默认最长上升子序列的长度，就是只有自己本身，也就是1*/
            dp[i] = 1;
            /*在[i,j]的范围内，如果nums[i] > nums[j]，则表示处于上升中，更新dp[i]的值*/
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    /*注意这里不能直接dp[i] = dp[i] + 1,这里是一个循环，取最大值*/
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            /*更次每一轮的最大长度*/
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

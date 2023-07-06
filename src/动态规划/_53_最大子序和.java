package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 */
/*2023-7-6*/
public class _53_最大子序和 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

	static public int maxSubArray(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       /*dp[i]表示以i结尾的最大子序和*/
       int[] dp = new int[nums.length];
       int max = 0;
       dp[0] = nums[0];//默认第一个最大
        for (int i = 1; i < nums.length; i++) {
            //上一个值 > 0，则加进去
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max,dp[i]);//更新大小
        }
        return max;
    }
}

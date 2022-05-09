
/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author shenchunxing
 *
 */
public class _53_最大子序和 {
	public int maxSubArray(int[] nums) {
       if (nums.length == 0) return 0;
       int[] dp = new int[nums.length]; //dp[i]表示以i结尾的最大子序和
       dp[0] = nums[0];
       int max = nums[0];
       for (int i = 1; i < nums.length; i++) {
		  dp[i] = dp[i - 1] > 0 ? (dp[i - 1] + nums[i]) : nums[i]; 
		  max = Math.max(max, dp[i]);//每轮获取最大可能的值
	   }
       return max;
    }
}

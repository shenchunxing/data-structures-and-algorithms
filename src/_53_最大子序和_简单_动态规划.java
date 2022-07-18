
/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author shenchunxing
 *
 */
public class _53_最大子序和_简单_动态规划 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

	static public int maxSubArray(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       int[] dp = new int[nums.length];
       int max = 0;
       dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

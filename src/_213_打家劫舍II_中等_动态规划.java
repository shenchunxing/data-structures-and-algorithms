/**
 * https://leetcode.cn/problems/house-robber-ii/
 */
public class _213_打家劫舍II_中等_动态规划 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0],nums[1]);
        //偷窃了第一间，就不能偷窃最后一间，因此范围是[0,n-2]
        //不偷窃第一间，就可以偷窃最后一间，因此范围是[1,n-1]
        //比较两个较大的
        //dp[i] =  Math.max(dp[i -1],dp[i - 2] + nums[i])
        //考虑到每个dp只和dp[i -1]和dp[i -2]有关，优化成滚动数组
        return Math.max(robRange(nums,0,length - 2) , robRange(nums,1,length - 1));
    }

    private int robRange(int[] nums, int start , int end) {
        //相当于first = dp[0] ,second = dp[1];
        //相当于比较Math.max(dp[i -1],dp[i - 2] + nums[i])
        int first = nums[start] , second = Math.max(nums[start] , nums[start + 1]);
        for (int i = start + 2 ; i <= end ; i++) {
            int temp = second;
            second = Math.max(first + nums[i] , second);
            first = temp;
        }
        return second;
    }
}

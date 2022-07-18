/**
 * https://leetcode.cn/problems/PzWKhm/
 */
public class 剑指Offer_II_090_环形房屋偷盗 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);
        //偷窃了第一间，就不能偷窃最后一间，因此范围是[0,n-2]
        //不偷窃第一间，就可以偷窃最后一间，因此范围是[1,n-1]
        //比较两个较大的
        //dp[i] =  Math.max(dp[i -1],dp[i - 2] + nums[i])
        //考虑到每个dp只和dp[i -1]和dp[i -2]有关，优化成滚动数组
        return Math.max(getMoney(nums,0,len - 2),getMoney(nums,1,len - 1));
    }

    private int getMoney(int[] nums ,int start, int end) {
        //相当于first = dp[0] ,second = dp[1];
        //相当于比较Math.max(dp[i -1],dp[i - 2] + nums[i])
        int first = nums[start], second = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(second,first + nums[i]);
            first = temp;
        }
        return second;
    }
}

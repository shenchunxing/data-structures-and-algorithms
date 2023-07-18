package 动态规划;

/**
 * https://leetcode.cn/problems/PzWKhm/
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
/*2023-7-18*/
public class 剑指Offer_II_090_环形房屋偷盗 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
    }
    static public int rob(int[] nums) {
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

    static private int getMoney(int[] nums ,int start, int end) {
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

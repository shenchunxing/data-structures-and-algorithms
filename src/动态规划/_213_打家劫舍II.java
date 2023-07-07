package 动态规划;

/**
 * https://leetcode.cn/problems/house-robber-ii/
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
/*2023-7-6*/
public class _213_打家劫舍II {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
    }
   static public int rob(int[] nums) {
       //设置初始值
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

    /*在指定房屋范围内偷窃的最高金额[start,end]*/
   static private int robRange(int[] nums, int start , int end) {
       //first和second分别设置初始值，
       //first：上一次的最大值
       //second：最大值
       //遍历从start + 2开始，因为start和start + 1已经使用了
        int first = nums[start] , second = Math.max(nums[start] , nums[start + 1]);
        for (int i = start + 2 ; i <= end ; i++) {
            int temp = second;
            /*更新最大值，上一次的值first + nums[i]（nums[i]可能是负数*/
            second = Math.max(first + nums[i] , second);
            first = temp;
        }
        return second;
    }
}

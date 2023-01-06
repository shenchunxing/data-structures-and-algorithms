package 动态规划;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 */
public class _1480_一维数组的动态和 {
    public static void main(String[] args) {
        _1480_一维数组的动态和 o = new _1480_一维数组的动态和();
        System.out.println(o.runningSum(new int[]{1,2,3,4}));
    }
    //O(n)  O(1):用于保存结果的 dp 是必须使用的空间，此处不计入。
    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
}

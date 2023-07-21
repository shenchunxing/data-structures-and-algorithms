package 动态规划;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class _416_分割等和子集 {
    public static void main(String[] args) {
        _416_分割等和子集 ob = new _416_分割等和子集();
        System.out.println(ob.canPartition(new int[] {1,3,5,9}));//true
        System.out.println(ob.canPartition(new int[] {1,3,5,6}));//false
    }
    //动态规划：0-1背包问题
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        //求和、最大值
        int sum = 0 , maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum,num);
        }
        if (sum % 2 != 0) return false; //奇数不可能分割
        int target = sum / 2;
        if (maxNum > target) return false; //如果最大值超过了一半，肯定不能分割

        //dp[i][j]表示从数组的[0,i]范围内选取若干元素（可以一个都不选），是否存在一种方案使被去选取
        //的整数和等于j
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; //边界条件，什么都不选，target = 0。
        }
        dp[0][nums[0]] = true; //边界条件，target = nums[0],选了第一个

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target ; j++) {
                //对于当前数字num[i]，可选可不选，如果选了，则dp[i][j] = dp[i - 1][j - nums[i]]
                //如果不选，则dp[i][j] = dp[i - 1][j]
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j - nums[i]] | dp[i - 1][j];
                } else { //j < nums[i] ,则无法选择nums[i]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n -1][target];
    }
}

package 动态规划;

/**
 * https://leetcode.cn/problems/target-sum/
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class _494_目标和 {
    public static void main(String[] args) {
        _494_目标和 o = new _494_目标和();
        System.out.println(o.findTargetSumWays(new int[] {1,1,1,1,1},3));
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target; //差异大小
        //如果小于0，说明找不到，
        //如果是奇数也是不可能的，直接找不到
        if (diff < 0 || diff % 2 != 0) return 0;
        int n = nums.length, neg = diff / 2;//neg表示添加'-'的元素之和
        //问题转化成在数组nums 中选取若干元素，使得这些元素之和等于neg，计算选取元素的方案数。我们可以使用动态规划的方法求解
        //dp[i][j]表示在数组nums 的前i 个数中选取元素，使得这些元素之和等于j 的方案数
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n ; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                //不选num，方案是 dp[i - 1][j],选num，方案是dp[i - 1][j - num]
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                } else  { //不能选num
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][neg];
    }

    /**
     * 优化成一维
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target; //差异大小
        //如果小于0，说明找不到，
        //如果是奇数也是不可能的，直接找不到
        if (diff < 0 || diff % 2 != 0) return 0;
        int n = nums.length, neg = diff / 2;//neg表示添加'-'的元素之和
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg ; j>= num ;j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

    int count = 0;
    public int findTargetSumWays2(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return count;
    }

    private void backtrack(int[] nums , int target , int i , int sum) {
        if (i == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums,target,i + 1,sum + nums[i]);
            backtrack(nums,target,i + 1,sum - nums[i]);
        }
    }
}

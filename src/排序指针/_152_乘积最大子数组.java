package 排序指针;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 * 难度：中等
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 */
public class _152_乘积最大子数组 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }

    static public int maxProduct(int[] nums) {
        //默认最大值、最小值都是nums[0]
        /*保留最小值是为了负负得正的情况*/
        int max = nums[0],min = nums[0],ans = nums[0];
        for (int i = 1;i < nums.length;i++) {
            //保留下当前的最大值和最小值
            int mx = max , mn = min;
            //最大值：mx * nums[i]、nums[i]、mn * nums[i]三者比较
            max = Math.max(mx * nums[i],Math.max(nums[i],mn * nums[i]));
            //最小值：mn * nums[i]、nums[i]、mx * nums[i]三者比较，因为存在负负得正的情况。所以需要计算最小值
            min = Math.min(mn * nums[i],Math.min(nums[i],mx * nums[i]));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}

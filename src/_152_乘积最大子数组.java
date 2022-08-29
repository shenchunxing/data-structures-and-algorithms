public class _152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        //保留一个负最小值和一个正数最大值，因为存在负负得正的情况。
        int max = nums[0],min = nums[0],ans = nums[0];
        for (int i = 1;i < nums.length;i++) {
            int mx = max , mn = min;
            //最大值：（当前最大值 * 当前值num[i]） 比较 (当前值num[i] 和 当前最小值 * 当前值num[i] 的较小值) 中的较大值
            max = Math.max(mx * nums[i],Math.max(nums[i],mn * nums[i]));
            min = Math.min(mn * nums[i],Math.min(nums[i],mx * nums[i]));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}

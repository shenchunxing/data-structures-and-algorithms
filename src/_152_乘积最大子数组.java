public class _152_乘积最大子数组 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
    static public int maxProduct(int[] nums) {
        //默认最大值、最小值都是nums[0]
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

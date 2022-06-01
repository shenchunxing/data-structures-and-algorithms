import com.sun.source.doctree.SummaryTree;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
public class _209_长度最小的子数组 {
    /**
     * 滑动窗口O(n) O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (nums[0] == target) return 1;
        int ans = Integer.MAX_VALUE;
        int start = 0 , end = 0 , sum = 0;
        while (end < n) {
            sum += nums[end]; //先加上end的值
            while (sum >= target) { //如果>=target
                //满足了条件的情况下，最小的长度
                ans = Math.min(ans , end - start + 1);
                //减去start的值，并右移
                sum -= nums[start];
                start++;
            }
            end++; //每次循环。end++
        }
        //没有找到
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

package 排序指针;

import com.sun.source.doctree.SummaryTree;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 难度：中等
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
/*2023-7-10*/
public class _209_长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[] {2,3,1,2,4,3}));
    }
    /**
     * 滑动窗口O(n) O(1)
     */
    static public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (nums[0] == target) return 1;
        /*设置默认值*/
        int ans = Integer.MAX_VALUE;
        /*start和end分别代表满足>=target的数组的左右位置*/
        int start = 0 , end = 0 , sum = 0;
        while (end < n) {
            sum += nums[end]; //先加上end的值
            while (sum >= target) { //如果>=target
                //满足了条件的情况下，取较小的长度
                ans = Math.min(ans , end - start + 1);
                //在已经满足条件的情况下，去[start,end]范围内继续查找是否存在更小的长度
                sum -= nums[start];
                start++;
            }
            end++; //每次循环。end++
        }
        //没有找到
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

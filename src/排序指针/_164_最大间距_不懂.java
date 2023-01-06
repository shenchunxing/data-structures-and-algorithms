package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-gap/
 */
public class _164_最大间距_不懂 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 0;i < nums.length - 1; i++) {
            maxGap = Math.max(nums[i + 1] - nums[i],maxGap);
        }
        return maxGap;
    }
}


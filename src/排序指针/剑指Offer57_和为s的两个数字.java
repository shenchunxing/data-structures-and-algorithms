package 排序指针;

/**
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class 剑指Offer57_和为s的两个数字 {
    //双指针逼近
    public int[] twoSum(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s < target) l++;
            else if (s > target) r--;
            else return new int[] {nums[l], nums[r]};
        }
        return new int[0];
    }
}

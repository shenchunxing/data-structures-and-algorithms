package 二分搜索;

/**
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 */
public class 剑指Offer53_II_0_n_1中缺失的数字 {
    //二分搜索
    public int missingNumber(int[] nums) {
        int l = 0,r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] == m) { //在右半区
                l = m + 1 ;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}

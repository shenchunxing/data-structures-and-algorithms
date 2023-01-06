package 二分搜索;

/**
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 */
public class _334_递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int small = Integer.MAX_VALUE,mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid ) {//至此，num肯定大于small
                mid = num;
            } else if (num > mid) { //至此，num肯定大于small和mid
                return true;
            }
        }
        return false;
    }
}

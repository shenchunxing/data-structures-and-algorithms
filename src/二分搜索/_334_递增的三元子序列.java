package 二分搜索;

/**
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 * 难度：中等
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
/*2023-7-11*/
public class _334_递增的三元子序列 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6})); //1 4 6
    }
    /*双指针：small维护最小值，mid维护最大值*/
    static public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        /*默认值*/
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

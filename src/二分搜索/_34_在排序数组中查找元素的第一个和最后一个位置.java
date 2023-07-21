package 二分搜索;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 难度：中等
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 *
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,4,5},6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{7,8,9,10,11},6)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,4,5,6},6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,7,7,8,8,8,10},8)));
    }
	/**
	 * 我们要找的就是数组中「第一个等于 target 和第一个大于target的位置。
	 */
	static public int[] searchRange(int[] nums, int target) {
       int[] range = {-1, -1};
       if (nums == null || nums.length == 0) return range;
       /*找到第一个等于target的位置*/
       int leftIdx = extremeInsertionIndex(nums,target,true);
        //找不到符合target的开始索引
        /*1.当目标值大于数组中的所有元素，或者nums数组为空数组时，leftIdx的值将等于nums.length*/
        /*2.nums[leftIdx] != target这种情况是数组的范围包括了tagrget，但是数组中没有target*/
       if (leftIdx == nums.length || nums[leftIdx] != target) {
           return range;
       }

       //找到了
       range[0] = leftIdx; //开始索引
       range[1] = extremeInsertionIndex(nums,target,false) -1; //结束索引，需要-1,因为查找的是第一个大于target的位置，-1得到足厚一个等于target的位置
       return range;
    }

    /**
     * 查找target所在的索引，left表示是否是开始索引
     */
    static private int extremeInsertionIndex(int[] nums,int target,boolean isLeft) {
        int lo = 0 ;
        int hi = nums.length ;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            //如果是查找结束索引：nums[mid] > target
            //如果是查找开始索引：(isLeft && nums[mid] == target)
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

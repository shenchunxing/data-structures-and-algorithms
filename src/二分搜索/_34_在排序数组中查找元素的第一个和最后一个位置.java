package 二分搜索;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author shenchunxing
 *
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
    }
	/**
	 * 我们要找的就是数组中「第一个等于 target 和第一个大于target的位置。
	 */
	static public int[] searchRange(int[] nums, int target) {
       int[] range = {-1, -1};
       if (nums.length == 0 || nums == null) return range;
       int leftIdx = extremeInsertionIndex(nums,target,true);
       //找不到符合target的开始索引
       if (leftIdx == nums.length || nums[leftIdx] != target) {
           return range;
       }

       //找到了
       range[0] = leftIdx; //开始索引
       range[1] = extremeInsertionIndex(nums,target,false) -1; //结束索引，需要-1
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

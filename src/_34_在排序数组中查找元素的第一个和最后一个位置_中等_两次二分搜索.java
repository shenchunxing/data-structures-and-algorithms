
/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author shenchunxing
 *
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置_中等_两次二分搜索 {
	/**
	 * 我们要找的就是数组中「第一个等于 target 和第一个大于target的位置。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
       int[] range = {-1, -1};
       if (nums.length == 0 || nums == null) return range;
       int leftIdx = extremeInsertionIndex(nums,target,true);
       //说明找不到左侧 ，直接返回找不到
       if (leftIdx == nums.length || nums[leftIdx] != target) {
           return range;
       }

       //找到了
       range[0] = leftIdx; //左边部分最开始位置的索引
       range[1] = extremeInsertionIndex(nums,target,false) -1; //右边部分最后位置的索引
       return range;
    }

    /**
     * 查找target所在的索引，left表示是开始索引
     * @param nums
     * @param target
     * @param left
     * @return
     */
    private int extremeInsertionIndex(int[] nums,int target,boolean left) {
        int lo = 0 ;
        int hi = nums.length ;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            //如果太大，或者是左侧部分，同时等于target，直到找到和target相同的第一个值的位置
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

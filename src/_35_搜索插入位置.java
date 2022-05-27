/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class _35_搜索插入位置 {
    /**
     * 二分搜索
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left)  >> 1) + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}


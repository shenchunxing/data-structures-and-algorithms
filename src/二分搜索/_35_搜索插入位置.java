package 二分搜索;

/**
 * https://leetcode.cn/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
/*2023-7-4*/
public class _35_搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {2,3,4,5,6},3));
    }
    /**
     * 二分搜索
     */
   static public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return left;
    }
}


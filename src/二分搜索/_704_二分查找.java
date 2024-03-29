package 二分搜索;

/**
 * https://leetcode.cn/problems/binary-search/
 */
/*2023-7-11*/
public class _704_二分查找 {
    public int search(int[] nums, int target) {
        int low = 0 ,high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else  if (num > target) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return  -1;
    }
}

package 二分搜索;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */

/*2023-7-4*/
public class _33_搜索旋转排序数组 {

	public static void main(String[] args) {
		System.out.println(search(new int[] {4,5,6,7,1,2,3},6));
		System.out.println(search(new int[] {7,8,1,2,3,4,5,6},7));
		System.out.println(search(new int[] {7,8,1,2,3,4,5,6},10));
	}

	static public int search(int[] nums, int target) {
		int n = nums.length;
		/*特殊情况处理*/
		if (n == 0) return -1;
		if (n == 1) return nums[0] == target ? 0 : -1;
		
		int l = 0 , r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			/*中间位置，匹配到了*/
			if (nums[mid] == target ) {
				return mid;
			}
			//旋转点在右半区，则左半区是排序数组，可以二分搜索
			 if (nums[0] <= nums[mid]) {
				 /*逐渐缩小范围*/
				 if (nums[0] <= target && target <= nums[mid]) {
					r = mid - 1; 
				 } else {
					l = mid + 1;
				 }
			 } else { //旋转点在左半区，则右半区是排序数组，可以二分搜索
				 /*逐渐缩小范围*/
				 if (nums[mid] < target && target <= nums[n - 1]) {
					 l = mid + 1;
				 } else {
					 r = mid - 1;
				 }
			 }
		}
		
		return -1;
    }
}

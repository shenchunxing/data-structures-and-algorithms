package 二分搜索;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 必须设计一个时间复杂度为 O(log n) 的算法解决此问题：二分搜索
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

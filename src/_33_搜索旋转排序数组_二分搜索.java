/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class _33_搜索旋转排序数组_二分搜索 {

	public static void main(String[] args) {
		System.out.println(search(new int[] {4,5,6,7,1,2,3},6));
		System.out.println(search(new int[] {7,8,1,2,3,4,5,6},7));
	}

	static public int search(int[] nums, int target) {
		//二分搜索
		int n = nums.length;
		if (n == 0) return -1;
		if (n == 1) return nums[0] == target ? 0 : -1;
		
		int l = 0 , r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target ) {
				return mid;
			}
			//旋转点在右半区，则左半区是排序数组，可以二分搜索
			 if (nums[0] <= nums[mid]) {
				 if (nums[0] <= target && target <= nums[mid]) {
					r = mid - 1; 
				 } else {
					l = mid + 1;
				 }
			 } else { //旋转点在左半区，则右半区是排序数组，可以二分搜索
				 
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

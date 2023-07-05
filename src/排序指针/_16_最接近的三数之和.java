package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 */
/*2023-7-4*/
public class _16_最接近的三数之和 {
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {-1,2,1,-4},1));
	}
	//排序 + 双指针 ： 时间复杂度O(n^2) , 空间复杂度O(logN)
	static public int threeSumClosest(int[] nums, int target) {
		/*排序*/
		 Arrays.sort(nums);
		 /*默认数组的前3个数求和,不能设置为0，因为ans需要根据求和得来的。*/
		 int ans = nums[0] + nums[1] + nums[2];
		 for (int i = 0; i < nums.length; i++) {
			 int start = i + 1 , end = nums.length - 1;
			 while (start < end) {
				 int sum = nums[i] + nums[start] + nums[end];
				 //如果绝对值更小，说明更接近
				 if (Math.abs(target - sum) < Math.abs(target - ans)) {
					 ans = sum;
				 }
				 if (sum > target) {
					 end--;
				 } else if (sum < target) {
					 start++;
				 } else {
					 return ans; //找到了
				 }
			 }
		 }
		 return ans;
	 }
}

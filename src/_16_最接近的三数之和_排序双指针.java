import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author shenchunxing
 *
 */
public class _16_最接近的三数之和_排序双指针 {
	//排序 + 双指针 ： 时间复杂度O(n^2) , 空间复杂度O(logN)
	 public int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums);
		 int ans = nums[0] + nums[1] + nums[2];
		 for (int i = 0; i < nums.length; i++) {
			 int start = i + 1 , end = nums.length - 1;
			 while (start < end) {
				 int sum = nums[i] + nums[start] + nums[end];
				 //得到接近的值
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

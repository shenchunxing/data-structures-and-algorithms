import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author shenchunxing
 *
 */
public class _16_最接近的三数之和 {
	//排序 + 双指针 ： 时间复杂度O(n^2) , 空间复杂度O(logN)
	 public int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums); //排序
		 int ans = nums[0] + nums[1] + nums[2];
		 for (int i = 0; i < nums.length; i++) {
			 //从第二个开始遍历
			int  start = i + 1 , end = nums.length - 1;
			while (start < end) {
				//头尾向中间逼近
				int sum = nums[start] + nums[end] + nums[i];
				//比较绝对值：越小说明越接近target
				if (Math.abs(target - sum) < Math.abs(target - ans)) {
					ans = sum;
				} 
				if (sum > target) { //逐渐向左靠近
					end --;
				} else if (sum < target) { //逐向右靠近
					start ++;
				} else {
					return ans; //找到了
				}
			}
		}
		 
		 return ans;
	 }

}

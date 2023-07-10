package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 难度：简单
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
/*2023-7-10*/
public class _169_多数元素 {
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
	//O(n)
	static public int majorityElement(int[] nums) {
		//摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
		int count = 0, result = -1;
		for (int num : nums) {
			if (count == 0) { //如果count = 0了，票被抵消光了，重新设置众当前num为众数
				result = num;
			}
			if (num == result) {
				count++;
			} else {
				count--;
			}
		}
		return result; //留下的就是众数
	}
	
	//排序算法：O(nlog(n))
	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
}










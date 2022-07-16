import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * @author shenchunxing
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 */
public class _169_多数元素_简单_摩尔投票法 {
	public int majorityElement(int[] nums) {
		//摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
		int count = 0, result = -1;
		for (int num : nums) {
			if (count == 0) { //如果count = 0了，说明不是众数，需要重新设置众数
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
	
	//排序算法
	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
}










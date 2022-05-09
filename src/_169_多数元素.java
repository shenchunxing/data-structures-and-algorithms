import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * @author shenchunxing
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1：

输入：[3,2,3]
输出：3
示例 2：

输入：[2,2,1,1,1,2,2]
输出：2
 *
 */
public class _169_多数元素 {
	
	//排序算法
	public int majorityElement1(int[] nums) {

		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
	
	//哈希表
	public int majorityElement2(int[] nums) {
		
		//将所有的元素的数量都存入了map
		Map<Integer, Integer> map = count(nums);
		
 		Map.Entry<Integer, Integer> midEntry = null;
		//遍历拿到最大的那个
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (midEntry == null || entry.getValue() > midEntry.getValue()) {
				midEntry = entry;
			}
		}
		return midEntry.getKey();
	}

	private Map<Integer, Integer> count(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) { //不存在就存入
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1 ); //更新当前的数量
			}
		}
		return map;
	}
}










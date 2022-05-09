import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @author shenchunxing
 *
 */
public class _219_存在重复元素II {
	//哈希表：
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
		int num = nums[i];
		//已经存在下标j && i - j <= k
		if (map.containsKey(num) && i - map.get(num) <= k) {
			return true;
		}
		
		//记录每个num的最大下标
		map.put(num, i);
	}
		return false;
    }
	
	//滑动窗口
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			//i >k , 则下标i - k - 1的值移除,每次循环确保滑动窗口大小就是k
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			//如果不能添加成功，说明set里面已经存在相同的值
			if (!set.add(nums[i])) {
				return true;
			}
		}
		
		return false;
	}
}

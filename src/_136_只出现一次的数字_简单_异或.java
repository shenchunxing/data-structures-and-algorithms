/**
 * https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class _136_只出现一次的数字_简单_异或 {

	public int singleNumber(int[] nums) {
		/**
		 * 异或性质 a^0 = a
		 *         b^b = 0
		 *         a^b^c = a^(b^c) = b^(a^c) 
		 */
		int num = 0;
		for (int i : nums) {
			num = num ^ i;
		}
		return num;
	}

}

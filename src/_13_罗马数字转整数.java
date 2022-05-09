import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * @author shenchunxing
 *
 */
public class _13_罗马数字转整数 {
	public int romanToInt(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int ans = 0;
		/**
		 * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可
		 * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
		 */
		for (int i = 0; i < s.length(); i++) {
			int value = map.get(s.charAt(i));
			//左边数小于右边，则取反
			if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
				ans -= value;
				//左边数大于右边，则顺序相加
			} else {
				ans += value;
			}
		}
		
		return ans;
    }

}

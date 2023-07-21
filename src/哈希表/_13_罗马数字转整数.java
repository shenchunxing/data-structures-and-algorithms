package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class _13_罗马数字转整数 {
	public static void main(String[] args) {
		System.out.println(romanToInt("III"));//3
		System.out.println(romanToInt("IV"));//4 = -1 + 5
		System.out.println(romanToInt("IX"));//9 = -1 + 10
		System.out.println(romanToInt("LVIII"));//58 = 50 +5 + 1 + 1 + 1
	}
	static public int romanToInt(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int value = map.get(s.charAt(i));
			//找一个规律：下一个的数比当前要大，就取负数，否则就取正数，因为要取下一个数s.charAt(i + 1)，
			// 所以i的取值需要满足i < s.length() - 1
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

package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * @author shenchunxing
 *
 */
public class _205_同构字符串 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) return false; //长度不同，肯定不是同构字符串
		int len = s.length();
		Map<Character,Character> sMap = new HashMap<>();
		Map<Character,Character> tMap = new HashMap<>();
		for (int i = 0; i < len; i++) {
			char x = s.charAt(i);
			char y = t.charAt(i);
			if (sMap.containsKey(x) && sMap.get(x) != y) return false;//x和y的映射已经存在，但是通过x获取到的却不是y
			if (tMap.containsKey(y) && tMap.get(y) != x) return false;
			sMap.put(x,y);//s字符串当前扫描的字符x映射成y，同时t字符串当前扫描的字符y映射成x
			tMap.put(y,x);
		}
		return true;
    }
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * @author shenchunxing
 *
 */
public class _205_同构字符串 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) return false;
		
        Map<Character, Character> s_tMap = new HashMap<>(); 
        Map<Character, Character> t_sMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
			char x = s.charAt(i);
			char y = t.charAt(i);
			//x和y的映射已经存在，但是通过x获取到的却不是y
			if ((s_tMap.containsKey(x) && s_tMap.get(x) != y) || (t_sMap.containsKey(y) && t_sMap.get(y) != x)) {
				 return false;
			}
			
			s_tMap.put(x, y); //每次更新x和y的映射
			t_sMap.put(y, x);
		}
        return true;
    }

	public static void main(String[] args) {

	}
}

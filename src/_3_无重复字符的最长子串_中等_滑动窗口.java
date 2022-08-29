import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author MJ
 *
 */
public class _3_无重复字符的最长子串_中等_滑动窗口 {
	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring(new String("abcabccd")));
//		System.out.println(lengthOfLongestSubstring(new String("abcbc")));
		System.out.println(lengthOfLongestSubstring(new String("abbbbcd")));
	}

	//滑动窗口：维护一个不重复元素的队列，一旦出现重复，移除最左边的元素
	static public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		Map<Character,Integer> map = new HashMap<>();
		int max = 0 , left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) { //重复了，更新最左侧不重复的坐标位置
				left = Math.max(left,map.get(c) + 1);
			}
			map.put(c,i);
			max = Math.max(max,i - left + 1);//更新长度
		}
		return max;
	}

    public int lengthOfLongestSubstring1(String s) {
    	if (s == null) return 0;
    	char[] chars = s.toCharArray();
    	if (chars.length == 0) return 0;
    	
    	// 用来保存每一个字符上一次出现的位置
    	int[] prevIdxes = new int[128];
    	for (int i = 0; i < prevIdxes.length; i++) {
			prevIdxes[i] = -1;
		}
    	prevIdxes[chars[0]] = 0;
    	// 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
    	int li = 0;
    	int max = 1;
    	for (int i = 1; i < chars.length; i++) {
    		// i位置字符上一次出现的位置
    		int pi = prevIdxes[chars[i]];
    		if (li <= pi) {
    			li = pi + 1;
    		}
        	// 存储这个字符出现的位置
    		prevIdxes[chars[i]] = i;
        	// 求出最长不重复子串的长度
        	max = Math.max(max, i - li + 1);
		}
    	return max;
    }
    
    public int lengthOfLongestSubstring2(String s) {
    	if (s == null) return 0;
    	char[] chars = s.toCharArray();
    	if (chars.length == 0) return 0;
    	
    	// 用来保存每一个字符上一次出现的位置
    	Map<Character, Integer> prevIdxes = new HashMap<>();
    	int li = 0;
    	int max = 1; //最大值默认1
    	for (int i = 0; i < chars.length; i++) {
    		// i位置字符上一次出现的位置
    		Integer pi = prevIdxes.get(chars[i]);
    		if (pi != null && li <= pi) { //i下标对应的字符已经出现过了， 更新li,li从上一次出现的位置+1开始
    			li = pi + 1;
    		}
        	// 更新存储这个字符出现的位置
        	prevIdxes.put(chars[i], i);
        	// 求出最长不重复子串的长度 = 当前i的位置 - 上一次出现i对应的值的位置 + 1
        	max = Math.max(max, i - li + 1);
		}
    	return max;
    }
}

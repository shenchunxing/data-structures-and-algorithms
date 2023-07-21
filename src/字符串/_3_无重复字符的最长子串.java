package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * 队列、数组、滑动窗口
 */
public class _3_无重复字符的最长子串 {
	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring(new String("abcabccd")));
//		System.out.println(lengthOfLongestSubstring(new String("abcbc")));//3
		System.out.println(lengthOfLongestSubstring(new String("abba")));//2
//		System.out.println(lengthOfLongestSubstring(new String("abbbbcd")));
	}

	//滑动窗口：维护一个不重复元素的队列
	static public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		Map<Character,Integer> map = new HashMap<>();
		/*left表示不重复的子串的左边界*/
		int max = 0 , left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			/*为什么这里出现重复不能直接取left = map.get(c) + 1;？
			因为可能存在边界后退的问题。如'abba'，按照上面的写发，第二次出现的'a'，left = map.get(c) + 1 = 1；但是实际上第二次出现的'b'的时候
			left已经是map.get(c) + 1 = 2了。出现了后退的情况。会把第二次出现的'b'也算入长度。所以在更新的时候，一定要取最右的那个值
			* */
			if (map.containsKey(c)) {
				left = Math.max(left,map.get(c) + 1);
			}
			/*记录字符及其位置*/
			map.put(c,i);
			/*每次遍历过程中更新最大长度*/
			max = Math.max(max,i - left + 1);
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

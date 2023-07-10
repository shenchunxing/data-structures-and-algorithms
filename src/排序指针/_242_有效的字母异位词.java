package 排序指针;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 难度：简单
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */

/*2023-7-10*/
public class _242_有效的字母异位词 {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("rat","car"));
	}
	// 比较两个字符串每个字符的数量，
    static public boolean isAnagram(String s, String t) {
    	if (s == null || t == null) return false;
    	char[] schars = s.toCharArray();
    	char[] tchars = t.toCharArray();
    	if (schars.length != tchars.length) return false;
    	
    	int[] counts = new int[26];//用于保存26个字母的统计数量
    	for (int i = 0; i < schars.length; i++) { //统计每个字符的数量
			counts[schars[i] - 'a']++;
		}
    	
    	for (int i = 0; i < tchars.length; i++) { //如果发现某个字符的数量小于0，说明数量对不上
    		counts[tchars[i] - 'a'] --;
    		if (counts[tchars[i] - 'a'] < 0) return false;
		}
    	return true;
    }
}

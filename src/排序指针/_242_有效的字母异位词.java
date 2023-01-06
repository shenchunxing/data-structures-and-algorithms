package 排序指针;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 
 * @author MJ
 *
 */
public class _242_有效的字母异位词 {
	// s == anagram
    public boolean isAnagram(String s, String t) {
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

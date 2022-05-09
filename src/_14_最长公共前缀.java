import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author shenchunxing
 *
 */
public class _14_最长公共前缀 {
	
//	public String longestCommonPrefix(String[] strs) {
//		if (strs.length == 0 || strs == null) {
//			return "";
//		}
//		String firString = strs[0]; //第一个字符串
//		
//		//遍历第一个字符串
//		for (int i = 0; i < firString.length(); i++) {
//			char c = firString.charAt(i);
//			//从第二个字符串开始比较，比较第一个字符串的每个字符
//			for (int j = 1; j < strs.length; j++) {
//				//如果遍历完了 或者 不匹配了   直接返回
//				if (i == strs[j].length() || strs[j].charAt(i) != c) {
//					return firString.substring(0,i);
//				}
//			}
//		}
//		
//		return firString;
//	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null) return "";
		String firstStr = strs[0];
		
		for (int i = 0; i < firstStr.length(); i++) {
			char c = firstStr.charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return firstStr.substring(0, i); //返回前缀（并不是返回公共子串）
				}
			}
		}
		
		return firstStr;
	}
}



















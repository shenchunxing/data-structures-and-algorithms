/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author shenchunxing
 *
 */
public class _14_最长公共前缀_简单_和第一个字符串逐字符比较 {
	
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
		if (strs == null || strs.length == 0) return "";
		String firststr = strs[0]; //第一个字符串
		for (int i = 0; i < firststr.length(); i++) {
			char c = firststr.charAt(i);
			//j从1开始，因为0就是firststr
			for (int j = 1; j < strs.length; j++) { //firststr的每个字符都需要遍历每个字符串的i位置去匹配
				String strj = strs[j];
				//如果不匹配,返回
				//如果遍历结束了,返回
				if (c != strj.charAt(i) || i == strj.length() ) {
					return firststr.substring(0,i);
				}
			}
		}
		return firststr;
	}
}



















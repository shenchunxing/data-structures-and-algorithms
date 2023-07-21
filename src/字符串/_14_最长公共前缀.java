package 字符串;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author shenchunxing
 *
 */
public class _14_最长公共前缀 {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
	}
	static public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		/*取出第一个字符串作为标杆*/
		String firststr = strs[0];
		for (int i = 0; i < firststr.length(); i++) {
			char c = firststr.charAt(i);
			//从第二个字符串开始，匹配第一个字符串的每个字符
			for (int j = 1; j < strs.length; j++) {
				String strj = strs[j];
				//如果不匹配,可以返回了
				//如果有些较短的字符串遍历结束了,返回
				if (i == strj.length() || c != strj.charAt(i)) {
					return firststr.substring(0,i);
				}
			}
		}
		return firststr;
	}
}



















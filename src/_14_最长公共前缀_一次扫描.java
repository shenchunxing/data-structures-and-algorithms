/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author shenchunxing
 *
 */
public class _14_最长公共前缀_一次扫描 {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
	}
	static public String longestCommonPrefix(String[] strs) {
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



















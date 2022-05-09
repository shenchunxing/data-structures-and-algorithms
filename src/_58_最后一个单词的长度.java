
/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * @author shenchunxing
 *
 */
public class _58_最后一个单词的长度 {
	public int lengthOfLastWord(String s) {
     
		//倒着搜索
		int end = s.length() - 1;
		//去除空格后的最后一个字符
		while(end >= 0 && s.charAt(end) == ' ') {
			end --;
		}
		int start = end;
		//去除空格后的第一个字符
		while(start >= 0 && s.charAt(start) != ' ') {
			start --;
		}
		return end - start;
    }
}

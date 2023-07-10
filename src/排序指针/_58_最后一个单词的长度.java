package 排序指针;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * 难度：简单
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 */
/*2023-7-10*/
public class _58_最后一个单词的长度 {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("shen word "));
	}
	static public int lengthOfLastWord(String s) {
		/*end指向最后一个单词的尾部字符*/
		int end = s.length() - 1;
		//去除空格后的最后一个字符
		while(end >= 0 && s.charAt(end) == ' ') {
			end --;
		}
		int start = end;
		/*start指向最后一个单词的头部字符*/
		while(start >= 0 && s.charAt(start) != ' ') {
			start --;
		}
		return end - start;
    }
}

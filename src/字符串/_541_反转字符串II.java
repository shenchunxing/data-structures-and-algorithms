package 字符串;

import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
/*2023-7-4*/
public class _541_反转字符串II {
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg",2));
	}
	static public String reverseStr(String s, int k) {
		int n = s.length();
		char[] arr = s.toCharArray();
		//2k的步伐
		for (int i = 0; i < arr.length; i+= 2*k) {
			/**
			 * 确定翻转的起始位置和结束位置
			 * i = 0，则比较k和n的大小，较小值作为结束位置，i作为起始位置,注意右边界闭区间，需要-1
			 * i = 2k，则比较2k和n的大小，较小值作为结束位置，i作为起始位置,注意右边界闭区间，需要-1
			 */
			reverse(arr, i, Math.min(i + k, n) - 1);
		}
		return new String(arr);
    }
	
	/**
	 * 反转字符串	
	 * @param arr：字符串数组
	 * @param left：起始位置
	 * @param right：终点位置
	 */
	static private void reverse(char[] arr , int left , int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}

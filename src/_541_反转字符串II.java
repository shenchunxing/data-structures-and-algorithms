import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class _541_反转字符串II {
	public String reverseStr(String s, int k) {

		int n = s.length();
		char[] arr = s.toCharArray();
		//2k的步伐
		for (int i = 0; i < arr.length; i+= 2*k) {
			//比较i+k步伐大小和终点的大小
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
	private void reverse(char[] arr , int left , int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}

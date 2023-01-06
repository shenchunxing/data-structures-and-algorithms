package 字符串;

/**
 * https://leetcode.cn/problems/reverse-string/
 */
public class _344_反转字符串 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0 ,r = s.length - 1;
        while (l < r) {
            swap(l++,r--,s);
        }
    }

    private void swap(int a , int b, char[] nums) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

package 字符串;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class _567_字符串的排列 {
    /**
     * 双指针+滑动窗口
     */
    public boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;
        int[] count = new int[26];
        for (char c : str1) { //统计s1每个字符的数量
            count[c - 'a'] ++;
        }
        int l = 0, r = 0; //l、r表示滑动窗口的左右边界
        while (l < len2 - len1) {
            //当前循环找到了匹配的字符，连续匹配，字符数量--，滑动窗口变大
            while (r < l + len1 && count[str2[r] - 'a'] > 0) {
                count[str2[r] - 'a'] --;
                r++;
            }
            if (r == l + len1) return true; //滑动窗口大小等于r的位置大小，说明匹配了
            count[str2[l] - 'a'] ++;
            l++;//下一轮循环，位置重新设置
        }
        return false;
    }
}

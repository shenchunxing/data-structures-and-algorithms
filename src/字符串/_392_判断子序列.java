package 字符串;

/**
 * https://leetcode.cn/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
/*2023-7-4*/
public class _392_判断子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
    /*s默认是第一个字符，t一直在一个个遍历，直到匹配到s的字符，s才走下一个字符继续匹配*/
    static public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0 , j = 0 ; j < t.length(); j++) {
            /*匹配到字符，则i++，去匹配s的下一个字符*/
            if (s.charAt(i) == t.charAt(j)) {
                i++; //i++ , j++
                /*已经遍历完s，说明完全匹配。返回true*/
                if (i == s.length()) return true;
            }
        }
        return false;
    }
}

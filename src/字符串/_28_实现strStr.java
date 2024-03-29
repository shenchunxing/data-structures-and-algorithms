package 字符串;

/**
 * https://leetcode.cn/problems/implement-strstr/
 * 难度：中等
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1
 */
public class _28_实现strStr {
    public static void main(String[] args) {
        System.out.println(strStr("ksadbutsad","sad"));
    }
    static public int strStr(String haystack, String needle) {
       int n = haystack.length() , m = needle.length();
       char[] s = haystack.toCharArray() , p = needle.toCharArray();
       //长度至少为m，否则肯定匹配不够了
        for (int i = 0; i <= n - m; i++) {
            /*每遍历到i位置，让needle从头开始匹配，如果匹配到就继续匹配，直到完全匹配此时b的位置就是needle的长度m*/
            int a = i , b = 0;
            while (b < m && s[a] == p[b]) { //匹配了第一个字符，继续匹配
                a++;
                b++;
            }
            if (b == m) return i; //完全匹配
        }
        return -1;
    }
}

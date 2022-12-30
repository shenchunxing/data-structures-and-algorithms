/**
 * https://leetcode.cn/problems/implement-strstr/
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1
 */
public class _28_实现strStr_遍历匹配 {
    public static void main(String[] args) {
        System.out.println(strStr("ksadbutsad","sad"));
    }
    static public int strStr(String haystack, String needle) {
       int n = haystack.length() , m = needle.length();
       char[] s = haystack.toCharArray() , p = needle.toCharArray();
       //长度至少为m，否则肯定匹配不够了
        for (int i = 0; i <= n - m; i++) {
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

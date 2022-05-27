/**
 * https://leetcode.cn/problems/implement-strstr/
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1
 */
public class _28_实现strStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length() , m = needle.length();
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        for (int i = 0; i <= n - m ; i++) { //i的范围优化成n - m是因为，再大不可能匹配了。长度不够m了
            int a = i , b = 0;
            //匹配上了，就继续匹配
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == m) return i; //完全匹配
        }
        return -1;
    }
}

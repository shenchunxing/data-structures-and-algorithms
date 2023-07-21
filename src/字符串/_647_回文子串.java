package 字符串;

/**
 * https://leetcode.cn/problems/palindromic-substrings/
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class _647_回文子串 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));//["a", "a", "a", "aa", "aa", "aaa"]
        System.out.println(countSubstrings("abc"));//["a","b","c"]
    }

    //O(n^2)、O(1)
    static public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        /*扩展到2倍大小*/
        for (int i = 0; i < 2 * n - 1; ++i) {
            /*以i为中心，向左右两边扩展*/
            int l = i / 2, r = i / 2 + i % 2;
            /*发现字符相等，继续扩展，直到超过边界或者不相等为止*/
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                /*遇到1次相等，可以分离出一个回文串*/
                ++ans;
            }
        }
        return ans;
    }
}

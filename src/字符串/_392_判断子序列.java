package 字符串;

/**
 * https://leetcode.cn/problems/is-subsequence/
 */
public class _392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0 , j = 0 ; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) { //匹配到字符
                i++; //i++ , j++
                if (i == s.length()) return true; //已经遍历完s，提前返回true
            }
        }
        return false;
    }
}

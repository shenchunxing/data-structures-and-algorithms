package 牛客网;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 */
public class NC17_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("ababc"));
        System.out.println(getLongestPalindrome("aaabcd"));
        System.out.println(getLongestPalindrome("abbba"));
    }

    static public int getLongestPalindrome (String A) {
        if (A == null) return 0;
        char[] cs = A.toCharArray();
        if (cs.length <= 1) return 1;
        // 最长回文子串的长度（至少是1）
        int maxLen = 1;
        int i = 0;
        while (i < cs.length) {
            int l = i - 1;
            // 找到右边第一个不等于cs[i]的位置
            int r = i;
            while (++r < cs.length && cs[r] == cs[i]);
            // r会成为新的i
            i = r;

            // 从l向左，从r向右扩展,尽可能去获取更大的长度
            while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }

            // 扩展结束后，cs[l + 1, r)就是刚才找到的最大回文子串
            // ++l后，l就是刚才找到的最大回文子串的开始索引
            int len = r - ++l;
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}

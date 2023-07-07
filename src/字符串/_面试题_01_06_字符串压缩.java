package 字符串;

/**
 * https://leetcode.cn/problems/compress-string-lcci/
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
/*2023-7-7*/
public class _面试题_01_06_字符串压缩 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
    static public String compressString(String S) {
        int  i = 0 , j = 0 , n = S.length();
       StringBuilder builder = new StringBuilder();
        while (i < n) {
            while (j < n && S.charAt(i) == S.charAt(j)) j++; //统计当前字符的数量
            builder.append(S.charAt(i)).append(j - i); //拼接
            i = j;//从下个字符重新开始，直接跳到下个字符的开始位置
        }
        return builder.length() < n ? builder.toString() : S;
    }
}


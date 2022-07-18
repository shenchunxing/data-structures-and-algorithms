/**
 * https://leetcode.cn/problems/compress-string-lcci/
 */
public class _面试题_01_06_字符串压缩 {
    public String compressString(String S) {
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


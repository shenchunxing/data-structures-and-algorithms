/**
 * https://leetcode.cn/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列 {
    public static void main(String[] args) {
        int len = longestCommonSubsequence("abcde" ,"ace");
        System.out.println(len);
    }

    static public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        //较短长度的数组作为dp，可以节省内存
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }
        int[] dp = new int[colsChars.length + 1];
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur; //每次循环保留上一次的leftTop的值
                cur = dp[j];
                if (rowsChars[i - 1] == colsChars[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsChars.length];
    }
}

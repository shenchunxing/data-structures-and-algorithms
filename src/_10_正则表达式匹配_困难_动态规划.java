/**
 * https://leetcode.cn/problems/regular-expression-matching/
 */
public class _10_正则表达式匹配_困难_动态规划 {
    public boolean isMatch(String s, String p) {
        int m = s.length() ,n = p.length();
        //dp[i][j]表示m[i]和n[j]是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //p的第j个字符是"*",则可以匹配j-1这个字符多次
                if (p.charAt(j - 1) == '*') {
                    //默认当前是否匹配,取决于前一个字符是否匹配
                    dp[i][j] = dp[i][j - 2];
                    //如果匹配
                   if (matches(s,p,i,j)) {
                       dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else { //普通字符,当前是匹配的,就看前一个是否匹配就行
                    if (matches(s,p,i,j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    //判断s的第i个字符和p的第j个字符是否匹配
    private boolean matches(String s , String p , int i , int j) {
        if (i == 0) return false;
        //可以匹配任意字符
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

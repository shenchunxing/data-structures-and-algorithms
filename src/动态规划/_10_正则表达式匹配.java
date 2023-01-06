package 动态规划;

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 */
public class _10_正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("abc",".*"));
    }

    static public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //dp[i][j]表示m[i]和n[j]是否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0 ; i <= m;i++) {
            for (int j = 1; j <=n ;j++) {
                //p的第j个字符是"*",则可以匹配j-1这个字符多次
                if (p.charAt(j - 1) ==  '*') {
                    //判断p的第j-1的字符是否和s的第i个字符匹配
                    dp[i][j] = dp[i][j - 2];
                    //如果p的第j-1个字符和s的第i个字符匹配
                    if (matches(s,p,i,j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else { //如果当前这个字符不是*，而且当前是匹配的，则去匹配各自前一个字符
                    if (matches(s,p,i,j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    //判断s的第i个字符和p的第j个字符是否匹配
    static private boolean matches(String s , String p , int i , int j) {
        if (i == 0) return false;
        //可以匹配任意单个字符
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        //直接匹配字符是否相同
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

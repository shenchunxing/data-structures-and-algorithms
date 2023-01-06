package 动态规划;

/**
 * https://leetcode.cn/problems/wildcard-matching/
 */
public class _44_通配符匹配 {
    public boolean isMatch(String s, String p) {
        //dp[i][j]表示字符串s前i个字符和模式p的前j个字符是否匹配
        int m = s.length() , n = p.length();
        boolean[][] dp = new boolean[m + 1][n+ 1];
        dp[0][0] = true; //字符都是空串，匹配
        //dp[i][0] = false;因为空串无法匹配非空串，因为数组默认就是false，可以不写
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') { //因为*才能匹配空字符串，所以只有当p的前j个字符都是*，才能匹配
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (p.charAt(j - 1) == '*') { //如果第i个字符是*，可以匹配，选择匹配*，则dp[i - 1][j]，不选择则dp[i][j - 1]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; //如果是'？'，则前i - 1和 j - 1是否匹配
                } else { // 如果是普通字符，当前需要匹配，同时前i - 1和 j - 1也要匹配
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class _32_最长有效括号 {
    public static void main(String[] args) {
        _32_最长有效括号 ob = new _32_最长有效括号();
        System.out.println(ob.longestValidParentheses("()(()())"));
    }

    public int longestValidParentheses(String s) {
       if (s == null || s.length() < 2) return 0;
       int[] dp = new int[s.length()];// dp[i]：严格以i位置结尾，形成的有效括号子串最长长度是多少
       int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1]; // 前面已经形成的有效括号长度
                int pre = i - 1 - preLen; //pre是dp[i - 1]前一个位置
                if (pre >=0 && s.charAt(pre) == '(') { // 如果寻找到左括号：前面有效括号长度再往前一个位置是左括号
                    dp[i] = dp[i - 1] + 2; // 可以与当前的右括号闭合，有效长度增加2

                    // 【注意】此时，需要再往前看下，是否还有有效长度，如果有，合并过来
                    // 例如："()(()())" 当前在计算最后一个位置时，dp[7]已经等于 dp[6]+2 = 4+2
                    // 但需要再往前看一眼，dp[1]还有有效长度，合并过来 dp[7] = 4+2+2
                    // 那是否还需要再往前看？
                    // 不需要了，因为，如果前面还有有效长度，其长度肯定已经合并到dp[2]上了
                    // 因此，每次只需要再往前多看一眼就可以
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    //动态规划O(n) O(n)
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int len = s.length();
        int[] dp = new int[len];//dp[i]表示以i结尾的最长有效括号的长度
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') { //当前必须是右括号
                if (s.charAt(i - 1) == '(') { //如果上一个恰好是左括号，则拿到dp[i - 2]的值 + 2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //倒数第二个也是右括号的情况，说明最后一个括号的左括号一定在倒数第二个右括号对应的左括号的前面
                    //(())
                    //dp[i - 1] + 2 表示倒数第2个右括号的情况，dp[i - dp[i - 1] - 2]表示倒数第一个左括号前面的情况，可能形成了新的有效括号。
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

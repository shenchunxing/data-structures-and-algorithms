package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-invalid-parentheses/
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 */
public class _301_删除无效的括号 {
    public static void main(String[] args) {
        _301_删除无效的括号 o = new _301_删除无效的括号();
        System.out.println(o.removeInvalidParentheses("()())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        //lremove：应该删除的左括号数量
        //rremove：应该删除的右括号数量
        int lremove = 0, rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { //遍历到左括号，左括号数量++
                lremove++;
            } else if (s.charAt(i) == ')') { //遍历到右括号
                if (lremove == 0) { //左括号数量为0，右括号++
                    rremove++;
                } else { //左括号数量部不为0，左括号--
                    lremove--;
                }
            }
        }
        //至此，得到最少应该删除的左右括号的数量lremove、rremove，因为要匹配，左右括号数量肯定是一样的
        dfs(s,0,lremove,rremove,res);
        return res;
    }

    private void dfs(String str , int start , int lremove , int rremove, List<String> res) {
        //递归结束，如果该字符串有效（左右括号匹配），则添加作为一个答案
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            //剪枝去重
            if (i != start && str.charAt(i) == str.charAt(i - 1)) continue;
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) return;
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                dfs(str.substring(0,i) + str.substring(i + 1), i , lremove - 1, rremove, res);
            };
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                dfs(str.substring(0,i) + str.substring(i + 1),i,lremove,rremove - 1,res);
            }
        }
    }

    /**
     * 字符串是否是有效的：左右括号数量是否相等
     */
    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}

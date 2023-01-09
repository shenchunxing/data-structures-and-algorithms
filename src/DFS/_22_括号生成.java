package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        char[] chars = new char[2 * n];
        dfs(chars,n,n,0,ans);
        return ans;
    }

    static private void dfs(char[] chars , int leftRemain , int rightRemain , int index,List<String> ans) {
        if (chars.length == index) {
            ans.add(new String(chars));
            return;
        }
        //选择左括号
        if (leftRemain > 0) {
            chars[index] = '(';
            dfs(chars,leftRemain - 1,rightRemain ,index + 1,ans);
        }
        //如果左右括号数量不相等，且右括号数量还有，可以选择右括号
        if (rightRemain > 0 && leftRemain != rightRemain) {
            chars[index] = ')';
            dfs(chars,leftRemain,rightRemain - 1,index + 1,ans);
        }
    }
}

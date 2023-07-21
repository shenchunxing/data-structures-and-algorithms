package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * dfs、中等
 */
/*2023-7-4*/
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
        /*递归出口，已经遍历到了最后一层*/
        if (chars.length == index) {
            ans.add(new String(chars));
            return;
        }
        //什么时候选择左括号？如果还有左括号，就先选择左括号
        if (leftRemain > 0) {
            chars[index] = '(';
            /*选好后剩余左括号数量leftRemain - 1，然后进入下一层，*/
            dfs(chars,leftRemain - 1,rightRemain ,index + 1,ans);
        }
        //什么时候选择右括号？如果左右括号数量不相等（意思是前面有选择左括号），且右括号数量还有
        //rightRemain > 0不能省略，递归的时候需要rightRemain - 1
        if (rightRemain > 0 && leftRemain != rightRemain) {
            chars[index] = ')';
            dfs(chars,leftRemain,rightRemain - 1,index + 1,ans);
        }
    }
}

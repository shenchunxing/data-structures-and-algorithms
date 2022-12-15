import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22_括号生成_中等_dfs {
    public static void main(String[] args) {
        _22_括号生成_中等_dfs o = new _22_括号生成_中等_dfs();
        System.out.println(o.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        char[] chars = new char[2 * n];
        dfs(chars,n,n,0,ans);
        return ans;
    }

    private void dfs(char[] chars , int leftRemain , int rightRemain , int index,List<String> ans) {
        if (chars.length == index) {
            ans.add(new String(chars));
            return;
        }
        if (leftRemain > 0) { //剩余可选的左括号 > 0
            chars[index] = '(';
            dfs(chars,leftRemain - 1,rightRemain ,index + 1,ans);
        }
        if (rightRemain > 0 && leftRemain != rightRemain) { //剩余可选的右括号 > 0 && 相同数量情况下必须先选左括号
            chars[index] = ')';
            dfs(chars,leftRemain,rightRemain - 1,index + 1,ans);
        }
    }
}

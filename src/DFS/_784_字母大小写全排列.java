package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-case-permutation/
 */
public class _784_字母大小写全排列 {
    public List<String> letterCasePermutation(String s) {
        char[] words = s.toCharArray();
        List<String> ans = new ArrayList<>();
        dfs(words,0,ans);
        return ans;
    }

    private void dfs(char[] words , int level , List<String> ans) {
        if (level == words.length) { //得到一个答案
            ans.add(new String(words));
            return;
        }
        //如果是字母
        if (Character.isLetter(words[level])) {
            words[level] = Character.toUpperCase(words[level]); //转成大写，进入下一层
            dfs(words,level + 1, ans);
            words[level] = Character.toLowerCase(words[level]); //转成小写，进入下一层
            dfs(words,level + 1, ans);
        } else  { //如果不是字母，直接进入下一层
            dfs(words,level + 1, ans);
        }
    }
}

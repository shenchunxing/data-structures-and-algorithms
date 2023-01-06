package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-search-ii/
 */
public class _212_单词搜索II {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0 ; i < board.length ; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board,word.toCharArray(),i,j,0)) {
                        set.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    private boolean dfs(char[][] board , char[] word , int i, int j, int t) {
        //边界条件
        if (t == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word[t]) return false; //字符不匹配
        char ch = board[i][j];
        board[i][j] = '-';
        //进入下一层，4个方向去搜索
        dfs(board,word,i + 1,j,t + 1);
        dfs(board,word,i - 1,j,t + 1);
        dfs(board,word,i,j + 1,t + 1);
        dfs(board,word,i,j - 1,t + 1);
        board[i][j] = ch; //回溯
        return false;
    }
}

/**
 * https://leetcode.cn/problems/word-search/
 */
public class _79_单词搜索_中等_dfs {
    public static void main(String[] args) {
        System.out.println(exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCE"));
    }

   static public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从单词的第一个字符开始遍历 k = 0
                if (dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    static boolean dfs(char[][] board , char[] word , int i , int j , int k) {
        //明显的边界条件：i和j不在矩阵内，或者 当前单词的下标k对应的字符不等于当前扫描的字符
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        // 此处board[i][j] == word[k]，k是单词的最后一个下标，字符串已经完全匹配
        if (k == word.length - 1) return true;
        board[i][j] = '\0';//元素已经被访问过
        boolean res = dfs(board,word,i + 1,j , k +1) || //从下搜索
                dfs(board,word,i - 1,j , k +1) || //从上搜索
                dfs(board,word,i,j + 1 , k +1) || //从右搜索
                dfs(board,word,i,j - 1 , k +1) ; //从左搜索
        board[i][j] = word[k]; //回溯：还原当前矩阵元素
        return res;
    }
}

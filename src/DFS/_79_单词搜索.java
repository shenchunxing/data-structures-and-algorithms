package DFS;

/**
 * https://leetcode.cn/problems/word-search/
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
/*2023-7-6*/
public class _79_单词搜索 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }

   static public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        /*两层for循环去扫描矩阵，查找word是否存在*/
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从单词的第一个字符开始遍历 k = 0
                if (dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    static boolean dfs(char[][] board , char[] word , int i , int j , int k) {
        //边界条件：因为扫描过程中i和j会逐渐增大，如果i和j不在矩阵内
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ) return false;
        /*当前字符已经被扫描过了 或者 当前单词的下标k对应的字符不等于当前扫描的字符*/
        if (board[i][j] == '\0' || board[i][j] != word[k]) return false;
        // 此处board[i][j] == word[k]，k是单词的最后一个下标，说明字符串已经完全匹配
        if (k == word.length - 1) return true;
        board[i][j] = '\0';//标记元素已经被访问过
        /*从i，j的位置出发，上下左右搜索是否匹配字符k*/
        boolean res = dfs(board,word,i + 1,j , k +1) ||
                dfs(board,word,i - 1,j , k +1) ||
                dfs(board,word,i,j + 1 , k +1) ||
                dfs(board,word,i,j - 1 , k +1) ;
        /*为了防止重复搜索，上面给board[i][j] = '\0'标记了，这里需要回溯：还原当前矩阵元素*/
        board[i][j] = word[k];
        return res;
    }
}

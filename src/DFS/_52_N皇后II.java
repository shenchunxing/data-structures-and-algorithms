package DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/n-queens-ii/
 */
public class _52_N皇后II {
    public static void main(String[] args) {
        _52_N皇后II ob = new _52_N皇后II();
        System.out.println(ob.totalNQueens(4));
        System.out.println(ob.totalNQueens(6));
        System.out.println(ob.totalNQueens(8));
    }
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n,0,columns,diagonals1,diagonals2);
    }

    /**
     * 回溯去查找皇后
     */
    private int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) return 1; //超过了范围，返回一个解
        else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                //去重
                if (columns.contains(i)) continue; //列去重
                int diagonal1 = row - i; //对角线去重
                if (diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i; //对角线去重
                if (diagonals2.contains(diagonal2)) continue;

                columns.add(i); //可以放置皇后
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //增加皇后的数量
                count += backtrack(n, row + 1,columns,diagonals1,diagonals2);
                //回溯
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}

import java.util.*;

/**
 * https://leetcode.cn/problems/n-queens/
 */
public class _51_N皇后 {
    public static void main(String[] args) {
        _51_N皇后 ob = new _51_N皇后();
        System.out.println(ob.solveNQueens(4)); //4皇后
        System.out.println(ob.solveNQueens(6)); //6皇后
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queues = new int[n];
        Arrays.fill(queues, -1); //默认设置都为-1
        Set<Integer> columns = new HashSet<>(); //列
        Set<Integer> diagonals1 = new HashSet<>(); //两个对角线
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions,queues,n,0,columns,diagonals1,diagonals2);
        return solutions;
    }

    private void backtrack(List<List<String>>solutions, int[] queues, int n , int row ,
                           Set<Integer>columns ,Set<Integer>diagonals1,Set<Integer>diagonals2) {
        if (n == row) { //超过了数组范围，生成一个答案
            List<String> board = generateboard(queues,n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) { //遍历行
                //去重
                if (columns.contains(i)) continue; //列去重
                int diagonal1 = row - i; //对角线去重
                if (diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i; //对角线去重
                if (diagonals2.contains(diagonal2)) continue;

                queues[row] = i; //放置皇后
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                //去下一行尝试放置皇后
                backtrack(solutions, queues, n, row + 1, columns, diagonals1, diagonals2);

                //回溯
                queues[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    /**
     * 生成答案需要的格式
     */
    private List<String> generateboard(int[] queues , int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

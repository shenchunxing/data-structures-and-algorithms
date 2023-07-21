package 排序指针;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class _73_矩阵置零 {
    public static void main(String[] args) {
        _73_矩阵置零 ob = new _73_矩阵置零();
        ob.setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
    }
    //标记变量O(mn) O(1)：用第0行和第0列的falg去标记
    //先让第0行和第0列部分填充'0'
    //再让填充'0'的位置扩展到当前行和当前列
    //再让第0行和第0列全部填充'0'
    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        boolean flagRow = false, flagCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true; //第0列有出现0
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow = true; //第0行有出现0
            }
        }
        //处理第1行到第n - 1行
        //让第0行和第0列先填充'0'
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //将剩下的部分填充'0'
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //最后处理第0行和第0列，如果存在0，则全部置为0
        if (flagCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }


    //标记数组O(mn) 、O(m + n)
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        /*先标记*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true; //记录i行和j列都需要清零
                }
            }
        }
        /*后清零*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;//在i行j列都需要清零
                }
            }
        }
    }
}

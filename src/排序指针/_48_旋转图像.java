package 排序指针;

/**
 * https://leetcode.cn/problems/rotate-image/
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class _48_旋转图像 {
    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    static public void rotate(int[][] matrix) {
        int n = matrix.length;
        /**
         * [             [
         *   [1,2,3],      [1,4,7],
         *   [4,5,6],  ->  [2,5,8],
         *   [7,8,9]       [3,6,9]
         * ],            ]
         */
        //转置矩阵：互换行列
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        /**
         * [             [
         *   [1,4,7],      [7,4,1],
         *   [2,5,8],  ->  [8,5,2],
         *   [3,6,9]       [9,6,3]
         * ],            ]
         */
        //翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // 列数转换一半
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}

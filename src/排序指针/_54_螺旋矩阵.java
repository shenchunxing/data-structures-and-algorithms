package 排序指针;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 难度：中等
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
/*2023-7-7*/
public class _54_螺旋矩阵 {
    public static void main(String[] args) {
//        System.out.println(spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
    static public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // right top -> right bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 螺旋区域已经缩小到一个点、一行或者一列的情况。此时，再继续进行循环没有意义，并且可能会导致重复输出已经输出过的元素
            if (top > bottom || left > right) break;

            // right bottom -> left bottom
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            // left bottom -> left top
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}

public class 剑指Offer04_二维数组中的查找_二分查找 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        //从最后一排的第一个开始，提高查找效率
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

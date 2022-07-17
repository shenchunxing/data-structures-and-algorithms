/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */
public class _240_搜索二维矩阵II_中等_二分搜索 {
    //Z字查找O(m + n) O(1)
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

    //二分搜索O(mlogN) O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row,target); //一行行扫描下去
            if (index != -1) return true;
        }
        return false;
    }
    private int search(int[] nums , int target) {
        int low = 0 , high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if(num > target) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }
}

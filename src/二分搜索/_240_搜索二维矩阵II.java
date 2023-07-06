package 二分搜索;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *   每行的元素从左到右升序排列。
 *   每列的元素从上到下升序排列。
 */
/*2023-7-6*/
public class _240_搜索二维矩阵II {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,5));
        System.out.println(searchMatrix2(matrix,5));
    }

    //Z字查找O(m + n) O(1)
    static public boolean searchMatrix(int[][] matrix, int target) {
       int row = matrix.length - 1;
       int col = 0;
       //从最后一排的第一个开始，提高查找效率，每次都减少一行或一列的查找范围
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
    static public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row,target); //一行行扫描下去，log(n)的复杂度
            if (index != -1) return true; //如果找到，直接return true
        }
        return false;
    }
    /*二分搜索*/
    static private int search(int[] nums , int target) {
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

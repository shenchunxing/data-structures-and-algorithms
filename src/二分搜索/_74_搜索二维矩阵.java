package 二分搜索;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author shenchunxing
 *
 */
public class _74_搜索二维矩阵 {
	public boolean searchMatrix(int[][] matrix, int target) {

		//找到行
		int rowIndex = binarySearchFirstCol(matrix, target);
		if (rowIndex  <0) {
			return false;
		}
		//找到列
		return binarySearchRow(matrix[rowIndex], target);
    }
	//找到所在的行
	private int binarySearchFirstCol(int[][] matrix , int target) {
		int low = -1 , high = matrix.length - 1;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			if (matrix[mid][0] <= target) { //取出当前行的第一个值
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
	
	//找到所在的列
	private boolean binarySearchRow(int[] row , int target) {
		int low = 0,high = row.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (row[mid] == target) {
				return true;
			} else if (row[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}

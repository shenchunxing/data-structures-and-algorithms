/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author shenchunxing
 *
 */
public class _74_搜索二维矩阵 {
	public boolean searchMatrix(int[][] matrix, int target) {

		int rowIndex = binarySearchFirstCol(matrix, target);
		if (rowIndex  <0) {
			return false;
		}
		
		return binarySearchRow(matrix[rowIndex], target);
    }
	
	/**
	 * 过滤掉不符合的行，找到可能存在target的行
	 * @param matrix
	 * @param target
	 * @return
	 */
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
	
	/**
	 * 查找行里面是否存在target
	 * @param row
	 * @param target
	 * @return
	 */
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

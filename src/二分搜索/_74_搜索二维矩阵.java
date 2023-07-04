package 二分搜索;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author shenchunxing
 *
 */
/*2023-7-4*/
public class _74_搜索二维矩阵 {
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},5));
	}

	/*用2个循环分开写效率更高*/
	static public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0].length == 0) return false;
		//找到行
		int rowIndex = binarySearchFirstCol(matrix, target);
		/*没有找到所在的行，直接false*/
		if (rowIndex < 0) {
			return false;
		}
		//从找好的行的rowindex，继续找到列，从而定位target所在的位置
		return binarySearchRow(matrix[rowIndex], target);
    }
	//找到所在的行，列都是第0列
	static private int binarySearchFirstCol(int[][] matrix , int target) {
		int low = -1 , high = matrix.length - 1;
		while (low < high) {
			/*这里+1是因为：low 和 high 的初值分别为 -1 和 matrix.length - 1，它们代表了搜索范围的左右边界。因此，high - low + 1 表示当前搜索范围的元素个数。通过这个计算，可以确保在有奇数个元素的情况下，中间值靠右取，而在有偶数个元素的情况下，中间值靠左取。是为了更好地逼近目标值。请注意，这种计算方式只适用于初始 low 值为 -1 的情况。*/
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
	static private boolean binarySearchRow(int[] row , int target) {
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

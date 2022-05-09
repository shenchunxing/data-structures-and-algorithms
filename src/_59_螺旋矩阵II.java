import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @author shenchunxing
 *
 */
public class _59_螺旋矩阵II {
	 public int[][] generateMatrix(int n) {
		 int left = 0, right = n - 1, top = 0 ,bottom = n - 1;
		 int [][] ans = new int[n][n];
		 int num = 1 , target = n * n; //从1开始，最大n*n;
		 while (num <= target) {
			 //left ->right
			 for (int i = left ; i<= right ; i++) {
				 ans[top][i] = num;
				 num++;
			 }
			 top++; //进入下一层
			 
			//top ->bottom
			 for (int i = top ; i<= bottom ; i++) {
				 ans[i][right] = num;
				 num++;
			 }
			 right--;
			 
			//right ->left
			 for (int i = right ; i>= left ; i--) {
				 ans[bottom][i] = num;
				 num++;
			 }
			 bottom--;
			 
			//bottom ->top
			 for (int i = bottom ; i>= top ; i--) {
				 ans[i][left] = num;
				 num++;
			 }
			 left++;
		 }
		 
		 return ans;
	 }
}

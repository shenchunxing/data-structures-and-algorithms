package 排序指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 难度：中等
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
/*2023-7-14*/
public class _59_螺旋矩阵II {
	public static void main(String[] args) {
	   	System.out.println(Arrays.deepToString(generateMatrix(3)));
	}

	/*思路：按照遍历顺序打印即可*/
	static public int[][] generateMatrix(int n) {
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

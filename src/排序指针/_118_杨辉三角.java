package 排序指针;

import java.util.ArrayList;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 难度：简单
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
/*2023-7-14*/
public class _118_杨辉三角 {

	public static void main(String[] args) {
		System.out.println(generate(3));
	   System.out.println(generate(5));
	}

	static public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				/*找规律：第一列和最后一列必定是1*/
				if (j== 0 || j == i) {
					row.add(1);
					/*[i,j] = [i - 1][j - 1] + [i - 1][j] */
				} else {
					int lastrow_left = ret.get(i - 1).get(j-1); //上一行的左
					int lastrow_right = ret.get(i - 1).get(j);//上一行的右
					row.add(lastrow_left + lastrow_right); //求和
				}
			}
			ret.add(row);
		}
        return ret;
    }
}

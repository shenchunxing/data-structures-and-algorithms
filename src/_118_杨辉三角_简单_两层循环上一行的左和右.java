import java.util.ArrayList;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @author shenchunxing
 *
 */
public class _118_杨辉三角_简单_两层循环上一行的左和右 {

	public static void main(String[] args) {
		System.out.println(generate(3));
	   System.out.println(generate(5));
	}

	static public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j== 0 || j == i) { //边上的肯定是1
					row.add(1);
				} else {
					int lastrow_left = ret.get(i - 1).get(j-1); //上一行的左
					int lastrow_right = ret.get(i - 1).get(j);//上一行的右
					row.add(lastrow_left + lastrow_right);
				}
			}
			ret.add(row);
		}
        return ret;
    }
}

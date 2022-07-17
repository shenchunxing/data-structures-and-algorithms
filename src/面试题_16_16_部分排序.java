/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 
 * @author MJ
 *
 */
public class 面试题_16_16_部分排序 {
	/*
	 * { 1, 5, 4, 3, 2, 6, 7 }
	 */
	
    public int[] subSort(int[] array) {
		if (array == null || array.length == 0) return new int[]{-1,-1};
		int max = array[0] , r = -1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= max) max = array[i];
			else r = i; //找到从左往右扫描的最后一次逆序位置
		}

		int min = array[array.length - 1] , l = -1;
		for (int j = array.length - 2; j >= 0 ; j--) {
			if (array[j] > min) {
				l = j; //找到从右往左扫描的最后一次逆序位置
			} else {
				min = array[j];
			}
		}
		return new int[]{l ,r};
    }
}

package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 难度：中等
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 */
/*2023-7-10*/
public class 面试题_16_16_部分排序 {
	/*
	 * { 1, 5, 4, 3, 2, 6, 7 }
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(subSort(new int[] {1, 5, 4, 3, 2, 6, 7})));
	}
    static public int[] subSort(int[] array) {
		if (array == null || array.length == 0) return new int[]{-1,-1};
		/*r是记录最后一个逆序对出现的位置*/
		int max = array[0] , r = -1;
		/*从左到右，扫描一次，找到最后一个逆序对的位置*/
		for (int i = 1; i < array.length; i++) {
			/*注意如果是正序的情况，也要更新最大值，因为后面遍历到的数是和前一个数比较的*/
			if (array[i] >= max) {
				max = array[i];
			} else  {
				r = i;
			}
		}

		/*如果r还是-1.说明已经是正序了*/
		if (r == -1) return new int[] {-1,-1};

		/*从右到左，扫描一次，找到最后一个逆序对的位置*/
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

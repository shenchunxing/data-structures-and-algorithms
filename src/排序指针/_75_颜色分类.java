package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author MJ
 *
 */
public class _75_颜色分类 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortColors(new int[] {1,2,2,0,1,0})));
	}
	///3指针
   static public int[] sortColors(int[] nums) {
		//i扫描 ，l是0填充的位置，r是2填充的位置
		int l = 0 , r = nums.length - 1 , i = 0;
		while (i <= r) {
			if (nums[i] == 0) {
				swap(l++,i++,nums);
			}
			else if (nums[i] == 1) {
				i++;
			}
			else {
				swap(i,r--,nums);
			}
		}
		return nums;
	}

	static private void swap(int l , int r , int[] nums) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}

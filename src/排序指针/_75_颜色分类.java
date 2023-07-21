package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 难度：中等
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
/*2023-7-14*/
public class _75_颜色分类 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortColors(new int[] {1,2,2,0,1,0})));
	}
	///3指针
   static public int[] sortColors(int[] nums) {
		//i扫描 ，l是0填充的位置，r是2填充的位置
		int l = 0 , r = nums.length - 1 , i = 0;
		while (i <= r) {
			/*如果是0，将0放前面*/
			if (nums[i] == 0) {
				swap(l++,i++,nums);
			}
			/*如果是1，不用动，直接遍历下一个即可*/
			else if (nums[i] == 1) {
				i++;
			}
			/*如果是2，将2放后面，注意：这里没有i++，由于 nums[r] 可能是0、1或者2，我们需要继续处理这个位置的元素，因此 i 不需要递增*/
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

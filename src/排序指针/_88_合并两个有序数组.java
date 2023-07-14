package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 难度：中等
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
/*2023-7-14*/
public class _88_合并两个有序数组 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1,nums1.length - nums2.length,nums2,nums2.length);
		System.out.println(Arrays.toString(nums1));
	}
	/**
	 * 双指针法
	 * nums1数组更大，nums2合并到nums1，从尾部开始比较
	 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		//i1是nums1的最后一个元素下标 ， i2是nums2的最后一个元素下标
		//cur指向nums1的可以放的位置
		int i1 = m - 1 , i2 = n - 1, cur = nums1.length - 1;
		//i2结束，剩下的nums1不用动了
		while (i2 >= 0) {
			//存在l1可能为空的情况，需要判断
			//因为l1的值比较大，填充
			if (i1 >= 0 && nums1[i1] >= nums2[i2]) {
				nums1[cur] = nums1[i1];
				i1--;
				cur--;
			} else {
				nums1[cur] = nums2[i2];
				i2--;
				cur--;
			}
		}
    }
}

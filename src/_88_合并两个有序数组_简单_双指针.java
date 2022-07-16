/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author MJ
 *
 */
public class _88_合并两个有序数组_简单_双指针 {
	/**
	 * 双指针法
	 * nums1数组更大，nums2合并到nums1，从尾部开始比较
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		//i1是nums1的最后一个元素下标 ， i2是nums2的最后一个元素下标
		//cur指向nums1的可以放的位置
		int i1 = m - 1 , i2 = n - 1, cur = nums1.length - 1;
		//i2结束，剩下的nums1不用动了
		while (i2 >= 0) {
			//i1可能已经结束
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

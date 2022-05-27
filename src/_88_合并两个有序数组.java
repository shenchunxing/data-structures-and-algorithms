/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author MJ
 *
 */
public class _88_合并两个有序数组 {
	/**
	 * 双指针法
	 * nums1数组更大，nums2合并到nums1，从尾部开始比较
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i1 = m - 1;
    	int i2 = n - 1;
    	int cur = nums1.length - 1;
    	
    	while (i2 >= 0) { 
    		if (i1 >= 0 && nums2[i2] < nums1[i1]) { //比较最后一个数
    			nums1[cur--] = nums1[i1--]; //移动到最后
    		} else { // i1 < 0 || nums2[i2] >= nums1[i1]
    			nums1[cur--] = nums2[i2--]; //直接填充
    		}
    	}

    }
}

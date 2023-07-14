package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 难度：简单
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
/*2023-7-10*/
public class _977_有序数组的平方 {
    public static void main(String[] args) {
        int[] sored = sortedSquares(new int[] {-4,-1,0,3,10});
        System.out.println(Arrays.toString(sored)); //[0, 1, 9, 16, 100]
    }
	/**
	 * 双指针,逆序填充
	 */
	//[-4,-1,0,3,10] -> [0,1,9,16,100]
	static public int[] sortedSquares(int[] nums) {
		int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        int location = n - 1; //填充的位置
        while (l <= r) {
            /*左边的负数平方 > 右边的正数平方*/
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[location] = nums[l] * nums[l];
                ++l;
            } else {
                ans[location] = nums[r] * nums[r];
                --r;
            }
            --location;
        }
        return ans;
    }

}

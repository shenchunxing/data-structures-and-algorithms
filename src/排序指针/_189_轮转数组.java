package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/
 * 难度：中等
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
/*2023-7-14*/
public class _189_轮转数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    //翻转
    //现将所有元素翻转，再将[0,k-1]翻转,最后翻转[k,nums.length -1]
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;//防止越界
        /*翻转整个数组*/
        reverse(nums,0,nums.length - 1);
        /*翻转前k个元素*/
        reverse(nums,0,k - 1);
        /*翻转后length - k个元素*/
        reverse(nums,k,nums.length - 1);
    }

    //翻转start到end的区域
    static private void reverse(int[] nums, int start , int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

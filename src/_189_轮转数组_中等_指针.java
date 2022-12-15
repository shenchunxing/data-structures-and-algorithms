/**
 * https://leetcode.cn/problems/rotate-array/
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */

public class _189_轮转数组_中等_指针 {

    //翻转
    //现将所有元素翻转，再将[0,k-1]翻转,最后翻转[k,nums.length -1]
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;//防止越界
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
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

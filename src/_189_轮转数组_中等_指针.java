/**
 * https://leetcode.cn/problems/rotate-array/
 */
public class _189_轮转数组_中等_指针 {
    //翻转
    //现将所有元素翻转，再将[0,k-1]翻转,最后翻转[k,nums.length -1]
    public void rotate(int[] nums, int k) {
        k = k % nums.length;//防止越界
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    //反转指定区域
    private void reverse(int[] nums, int start , int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //额外数组
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
    }
}

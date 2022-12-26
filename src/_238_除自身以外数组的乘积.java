import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 * 要求O(n)时间复杂度，不能用除法
 */
public class _238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
    }
   static public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
       answer[0] = 1;
       // answer[i] 表示索引 i 左侧所有元素的乘积
       // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

       // r 为右侧所有元素的乘积
       // 刚开始右边没有元素，所以 r = 1
        int r = 1;
        for (int j = nums.length - 1; j >= 0 ; j--) {
            answer[j] *= r; //乘的是上一个循环得到的r
            r *= nums[j];
        }
        return answer;
    }
}

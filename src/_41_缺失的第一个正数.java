/**
 * https://leetcode.cn/problems/first-missing-positive/
 */
public class _41_缺失的第一个正数 {
    public static void main(String[] args) {
       System.out.println(firstMissingPositive(new int[]{3,4,-1,1,9,-5}));//2
    }
   static public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将所有负数都变成n+1,因为缺失的正数最大就是n+1，这样可以把所有负数都转成了正数来处理
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //将<=n的元素对应位置变成负数，这是一种标记，说明该位置的正数已经出现过了。
       //因为下标和值的关系 值 = 下标 + 1
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                //数字 - 1就是下标
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        //重新遍历
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                //找到第一个正数的位置+1
                return i + 1;
            }
        }
        //没找到,说明缺失的就是下一个数
        return n + 1;
    }
}

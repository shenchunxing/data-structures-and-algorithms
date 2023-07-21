package 二分搜索;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 位运算、数组、双指针
 */
public class _287_寻找重复数 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }
    //O(logn)
   static public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1,r = n - 1,ans = -1;
        //o(logn)
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            /*这里在统计小于mid的数字有多少，因为题目指定任意值都处于范围[1,n]内。*/
            for (int i = 0; i < n ;i ++) {
                if (nums[i] <= mid) { //数组中间下标 >= i对应的值
                    cnt ++;
                }
            }
            /*统计的数量 <= mid。说明那个重复的多出来的数在右半区，缩小范围*/
            if (cnt <= mid) {
                l = mid + 1;
            }else {
                r = mid - 1;
                /*先赋值，满足l <= r，还会继续排查，如果l > r了，mid就是答案*/
                ans = mid;
            }
        }
        return ans;
    }
}

package 二分搜索;

/**
 * https://leetcode.cn/problems/sqrtx/
 * 给你一个非负整数 x ，计算并返回x的算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
public class _69_x的平方根 {
    /**
     * 二分搜索：x的平方根的整数部分满足：K^2 <=x 的最大值
     */
    public static void main(String[] args) {
        System.out.println(mySqrt(6));
    }
   static public int mySqrt(int x) {
        int left = 0 , right = x , ans = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if ((long)mid * mid <= x) { //mid * mid可能超出范围
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

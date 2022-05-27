/**
 * https://leetcode.cn/problems/sqrtx/
 * 给你一个非负整数 x ，计算并返回x的算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class _69_x的平方根 {
    /**
     * 二分搜索：x的平方根的整数部分满足：K^2 <=x 的最大值
     */
    public int mySqrt(int x) {
        int l = 0 , r = x , ans = -1;
        while (l <= x) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

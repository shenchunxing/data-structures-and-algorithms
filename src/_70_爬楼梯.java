/**
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class _70_爬楼梯 {
    //数学[(1 + 根号5) / 2] ^ n - [(1 - 根号5) / 2] ^ n
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);//根号5
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

    //滚动数组:fib
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            second = second + first; //second = f(n - 1) + f(n - 2)
            first = second - first; //first = f(n - 1)
        }
        return second;
    }
}

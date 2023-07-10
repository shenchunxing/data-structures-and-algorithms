package 排序指针;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 难度：简单
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
/*2023-7-10*/
public class _70_爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(4));
    }

    //滚动数组:fib，斐波那契数列
   static public int climbStairs2(int n) {
        if (n < 2) return 1;
        /*保存上一个值*/
        int first = 1;
        /*保存当前值*/
        int second = 2;
        for (int i = 2; i < n; i++) {
            second = second + first;
            first = second - first;
        }
        return second;
    }

    //数学[(1 + 根号5) / 2] ^ n - [(1 - 根号5) / 2] ^ n
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);//根号5
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}

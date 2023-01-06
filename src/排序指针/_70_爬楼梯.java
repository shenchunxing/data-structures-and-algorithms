package 排序指针;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class _70_爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(4));
    }

    //滚动数组:fib
   static public int climbStairs2(int n) {
        if (n < 2) return 1;
        int first = 1;
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

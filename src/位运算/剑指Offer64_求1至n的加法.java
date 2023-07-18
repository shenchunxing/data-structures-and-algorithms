package 位运算;

/**
 * https://leetcode.cn/problems/qiu-12n-lcof/
 * 难度：中等
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路：短路效应:&&字符，如果n > 1 为false，则不会执行(n += sumNums(n - 1)) > 0，同时这也是递归的出口
 */
/*2023-7-18*/
public class 剑指Offer64_求1至n的加法 {

    public static void main(String[] args) {
        System.out.println(sumNums(10));
    }
    static public int sumNums(int n) {
        //短路效应:&&字符，如果n > 1 为false，则不会执行(n += sumNums(n - 1)) > 0，这是递归的出口
        // n + sumNums(n - 1)
        // n -1  + sumNums(n - 2)
        // 2  + sumNums(1)
        // 1
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

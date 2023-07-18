package 位运算;

/**
 * https://leetcode.cn/problems/number-of-1-bits/
 * 难度：简单
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 思路：位运算
 */

/*2023-7-18 不理解*/
public class _191_位1的个数 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(1));//1
        System.out.println(hammingWeight(5));//101
        System.out.println(hammingWeight(15));//1111
    }
    static public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1); //n & (n - 1)每次可以把n的二进制位的最低位的1变成0
        }
        return sum;
    }
}

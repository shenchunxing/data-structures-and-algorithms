package 数学;

/**
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
/*2023-7-4,不是很理解*/
public class _172_阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(7));
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(20));
        System.out.println(trailingZeroes(100));
    }
    // 需要确定在乘法过程中出现了多少个因子 10。而 10 可以分解为 2 和 5 的乘积，
    // 而 2 的数量要远大于 5 的数量，因此实际上只需计算因子 5 的个数即可
   static public int trailingZeroes(int n) {
        int zero = 0;
        while(n > 0 ) {
            n /= 5;
            zero += n ;
        }
        return zero;
    }
}

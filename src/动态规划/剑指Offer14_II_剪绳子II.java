package 动态规划;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 */
public class 剑指Offer14_II_剪绳子II {
    public static void main(String[] args) {
        System.out.println(cuttingRope(8));// 3 3 2
        System.out.println(cuttingRope(9));// 3 3 3
        System.out.println(cuttingRope(10));// 3 3 2 2
    }
    //推论：将绳子剪成等份，乘积最大
    //推论：尽可能将绳子以长度3等分为多段时，乘积最大，最后剩余的长度可能是2，1，如果是2，则保留2，如果是1，则把3 * 1替换成2 * 2
    //O(log2N) O(1)
    static public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        //b是余数
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        //逆序输出，循环得到3的个数 - 1
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        //可以整除3
        if(b == 0) return (int)(rem * 3 % p);
        //剩下的是1，需要将最后的一个3和剩下的1转换成2*2，因为3*1 < 2*2
        if(b == 1) return (int)(rem * 4 % p);
        //剩下的是2
        return (int)(rem * 6 % p);
    }
}

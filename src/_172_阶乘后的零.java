/**
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 */
public class _172_阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(20));
    }
    //尾随0的个数取决于有多少个10相乘，10来自2*5，2的数量肯定远远大于5的数量，
    // 因此只要找到n!可以分成多少个5相乘就可以
   static public int trailingZeroes(int n) {
        int zero = 0;
        while(n > 0 ) {
            n /= 5;
            zero += n ;
        }
        return zero;
    }
}

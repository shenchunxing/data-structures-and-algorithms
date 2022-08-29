/**
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 */
public class _172_阶乘后的零 {
    public int trailingZeroes(int n) {
        int zero = 0;
        while(n > 0 ) {
            n /= 5;
            zero += n ;
        }
        return zero;
    }
}

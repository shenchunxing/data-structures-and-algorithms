/**
 * https://leetcode.cn/problems/power-of-three/
 */
public class _326_3的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(27));
    }
   static public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}

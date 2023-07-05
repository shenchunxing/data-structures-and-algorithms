package 数学;

/**
 * https://leetcode.cn/problems/power-of-three/
 */
/*2023-7-4*/
public class _326_3的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(27));
    }
   static public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        /*n % 3 == 0 说明可以被3整除，缩小规模，继续直到最后，判断n == 1*/
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}

package 牛客网;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class _204_计数质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
   static public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    /*是否是质数*/
    static public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

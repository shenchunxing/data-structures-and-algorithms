package 位运算;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 难度：中等
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class _50_Pow {

    public static void main(String[] args) {
        System.out.println(myPow2(2,2));
        System.out.println(myPow2(3,3));

        System.out.println(powMod1(123,456,789));
        System.out.println(powMod2(123,456,789));
    }

    // T(n) = T(n/2) + O(1) = O(logn)
    //递归+分治思想
   static public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow2(x, n >> 1);
        half *= half;
        // 是否为奇数，奇数需要额外乘以x
        return ((n & 1) == 1) ? (half * x) : half;
    }

    //x^5 = x^101 = (4*x^1) * (2*x^0) * (1*x^1)
    //O(logn)
    public static double myPow(double x, int n) {
        if ( x == 0) return 0;
        long b = n;
        double res = 1.0;
        //如果是负数,转成正数
        if (b < 0) {
            x = 1/ x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) { //最后一位是1,
                res *= x;
            }
            x *= x;//系数变大
            b >>= 1; //让最后一位出去
        }
        return res;
    }

    //求x的y次幂，再模z的值
    public static int powMod1(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        int res = 1 % z;//直接取模，简化res = (res * x) % z;
        x %= z; //直接取模，简化x = (x * x) % z
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res = (res * x) % z;
            }
            x = (x * x) % z;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return res;
    }

    // 2^100 % 6  = (2^50 * 2^50) % 6 = ((2^50 % 6) * (2^50 % 6)) % 6
    // 2^101 % 6 = (2^50 * 2^50 * 2) % 6 = ((2^50 % 6) * (2^50 % 6) * (2 % 6)) % 6
    //递归、分治
    public static int powMod2(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        if (y == 0) return 1 % z;
        int half = powMod2(x, y >> 1, z);
        half *= half;
        if ((y & 1) == 0) { // 偶数
            return half % z;
        } else { // 奇数
            return (half * (x % z)) % z;
        }
    }
}

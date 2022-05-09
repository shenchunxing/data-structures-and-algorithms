/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class _7_整数反转 {

    //数学：时间复杂度O(logN),空间复杂度O(1)
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10  || rev > Integer.MAX_VALUE / 10)  {
                return  0;
            }
            int digital = x % 10; //得到最后那个数
            x /= 10;//弹出最后那个数
            rev = rev * 10 + digital;//推入
        }
        return  rev;
    }
    public static int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10; //拿到最后一个位
            if (res > Integer.MAX_VALUE) return 0;
            if (res < Integer.MIN_VALUE) return 0;
            x /= 10; //去掉最后一位
        }
        return (int) res;
    }

    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            int mod = x % 10;
            res = prevRes * 10 + mod;
            if ((res - mod) / 10 != prevRes) return 0;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(reverse(123));
    }
}

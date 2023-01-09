package 位运算;

/**
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 */
public class 剑指Offer16_数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(myPow2(4,3));
    }

    //递归+分治思想 O(logn)
    static public double myPow2(double x, int n) {
        if (n == 0) return 1; //特殊处理
        if (n == 1) return x;//递归基：递减到0退出
        if (n == -1) return 1 / x; //如果n是负数，最后递归到-1。
        double half = myPow2(x, n >> 1); //将数据规模减少一半
        half *= half;//得到完整的解
        // 是否为奇数，奇数需要额外乘以x
        return ((n & 1) == 1) ? (half * x) : half;
    }

    //快速幂算法
    //迭代
    public double myPow(double x, int n) {
        if (x == 0) return 0; //避免 x = 1/ x 报错
        long b = n;
        double ans = 1;
        //当n < 0 时，把问题转换成 n >= 0范围内
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        //将n转成二进制。遍历每一个二进制位，假设二进制数为1011(11) ,计算x^11,
        //遍历就是1101 = 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0
        //ans = 1起步
        //ans = ans * x = x
        //ans = ans * x = x * x^2
        //不计算
        //ans = ans * x = x^3 * x^8 = x^11
        while (b > 0) {
            if ((b & 1) == 1) {//每一轮判断最后一位如果是1，需要*x
                ans *= x;
            }
            x *= x;
            b >>= 1; //算好一位，则右侧一位
        }
        return ans;
    }
}

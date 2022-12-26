/**
 * https://leetcode.cn/problems/sum-of-two-integers/
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 */
public class _371_两整数之和 {
    public static void main(String[] args) {
        System.out.println(getSum(5,7));
    }

    /**
     * 位运算
     *  101
     *  111
     * 1100
     * 第一步：相加各位的值，不算进位，得到2。
     * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果
     * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
     */
   static public int getSum(int a, int b) {
        while (b != 0) {
            //计算进位后的加法结果(a & b) << 1，得到1010，也就是10
            int carry = (a & b) << 1;
            //不计算进位的情况下，无进位加法结果是a ^ b ，得到010，也就是2
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

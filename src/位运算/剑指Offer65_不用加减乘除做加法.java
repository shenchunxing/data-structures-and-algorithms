package 位运算;

/**
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class 剑指Offer65_不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(20,17));
    }
    /**
     *           非进位     进位
     * 0    0      0         0
     * 0    1      1         0
     * 1    0      1         0
     * 1    1      0         1
     *
     *
     * 20：00010100
     * 17：00010001
     * 37：00100101
     */

    //进位和 + 非进位和 = 答案
   static public int add(int a, int b) {
        while (b != 0) { //当进位为0，跳出
            int c = (a & b) << 1; //c = 进位
            a = a^b; //a = 非进位和
            b = c;//b = 进位
        }
        return a;
    }
}

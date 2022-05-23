/**
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class 剑指Offer65_不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(3,4));
    }
    /**
     * 20: 00010100
     * 17: 00010001
     * 37: 00100101
     * @param a
     * @param b
     * @return
     */
    //位运算：每一位相加
    //非进位和运算结果和异或相同，还需左移1位
    //进位和运算结果和与相同
    //没理解
   static public int add(int a, int b) {
        while (b != 0) { //当进位为0，跳出
            int c = (a & b) << 1; //进位操作：与
            a = a^b; //非进位操作：异或
            b = c;
        }
        return a;
    }
}

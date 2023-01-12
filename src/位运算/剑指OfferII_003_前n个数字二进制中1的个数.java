package 位运算;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/w3tCBm/
 */
public class 剑指OfferII_003_前n个数字二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(3)));
    }
    //最低有效位,递推
    static public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //i右移1位，等价于将其二进制表示的最低位去掉，(i & 1)可以得到最低位
            //如果bits[i >> 1]已知，推得bits[i]
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}

package 数学;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 难度：简单
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class 剑指Offer17_打印从1到最大的n位数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    static public int[] printNumbers(int n) {
        //如何获取最大的数，其实就是10的n次方 - 1
        int end = (int)Math.pow(10,n) - 1;
        int[] nums = new int[end];
        for (int i = 0; i < end; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}

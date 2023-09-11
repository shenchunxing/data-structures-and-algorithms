package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 给定一个由若干整数组成的数组nums ，可以在数组内的任意位置进行分割，
 * 将该数组分割成两个非空子数组（即左数组和右数组），分别对子数组求和得到两个值，计算这两个值的差值，请输出所有分割方案中，差值最大的值。
 *
 * 输入描述
 *
 * 第一行输入数组中元素个数n，1 < n ≤ 100000
 * 第二行输入数字序列，以空格进行分隔，数字取值为4字节整数
 * 输出描述
 *
 * 输出差值的最大取值
 *
 * 输入
 * 6
 * 1 -2 3 4 -9 7
 *
 * 输出
 * 10
 */
public class 分割数组的最大差值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(getResult(nums, n));
    }
    public static long getResult(long[] nums, int n) {
        long leftSum = 0;
        /*默认右数组是全数组求和*/
        long rightSum = Arrays.stream(nums).sum();
        long maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            /*左数组和右数组差值的绝对值最大*/
            long diff = Math.abs(leftSum - rightSum);
            /*更新最大值*/
            if (diff > maxDiff) maxDiff = diff;
        }
        return maxDiff;
    }
}

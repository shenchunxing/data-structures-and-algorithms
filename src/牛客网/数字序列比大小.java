package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * A，B两个人玩一个数字比大小的游戏，在游戏前，两个人会拿到相同长度的两个数字序列，两个数字序列不相同的且其中的数字是随机的。
 * A，B各自从数字序列中挑选出一个数字进行大小比较，赢的人得1分，输的人扣1分，相等则各自的分数不变。用过的数字需要丢弃。
 * 求A可能赢B的最大分数。
 *
 * 输入描述
 *
 * 输入数据的第1个数字表示数字序列的长度N，后面紧跟着两个长度为N的数字序列。
 *
 * 输出描述
 *
 * A可能赢B的最大分数
 *
 * 备注
 * 1.这里要求计算A可能赢B的最大分数，不妨假设，A知道B的数字序列，且总是B先挑选数字并明示
 * 2.可以采用贪心策略，能赢的一定要赢，要输的尽量减少损失。
 */
public class 数字序列比大小 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*数组长度*/
        int n = Integer.parseInt(in.nextLine());
        /*输入转成int数组*/
        int[] a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /*排序*/
        Arrays.sort(a);
        Arrays.sort(b);
        int left_a = 0;
        int right_a = n - 1;
        int left_b = 0;
        int right_b = n - 1;
        int result = 0;
        while (left_a <= right_a) {
            /*a赢b*/
            if (a[right_a] > b[right_b]) {
                result += 1;
                /*a、b同时--*/
                right_a--;
                right_b--;
            } else if (a[right_a] < b[right_b]) {
                /*如果a < b,a的左边界++，b的右边界--*/
                result -= 1;
                left_a++;
                right_b--;
            } else {
                /*如果相等，且此时a的左边界 > b的左边界*/
                if (a[left_a] > b[left_b]) {
                    result += 1;
                    /*a、b同时++*/
                    left_a++;
                    left_b++;
                } else {
                    /*如果相等，且此时a的左边界 < b的左边界*/
                    if (b[right_b] > a[left_a]) result -= 1;
                    /*a左边界++、b右边界--*/
                    left_a++;
                    right_b--;
                }
            }
        }
        System.out.println(result);
    }
}

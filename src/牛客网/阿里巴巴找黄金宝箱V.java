package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 *
 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字。
 阿里巴巴念出一个咒语数字k(k<N)，找出连续k个宝箱数字和的最大值，并输出该最大值。

 输入描述

 第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5
 字串中数字的个数>=1，<=100000；每个数字>=-10000，<=10000；
 第二行输入咒语数字，例如：4，咒语数字大小小于宝箱的个数

 输出描述

 连续k个宝箱数字和的最大值，例如：39
 */
public class 阿里巴巴找黄金宝箱V {
    /*控制左右边界，每次循环找出最大值*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        //滑窗的左侧边界
        int left = 0;
        //滑窗的右侧边界
        int right = 0;
        //滑窗内的总和
        int count = 0;
        //最大和
        int max = Integer.MIN_VALUE;
        while (right < ints.length) {
            count += ints[right];
            right++;
            if (right - left < k) {
                //滑窗大小不满足咒语数字则右边界继续向右滑动
                continue;
            }
            max = Math.max(max, count);
            //滑窗大小已经满足咒语数字，则左边界需要右移
            count -= ints[left];
            left++;
        }
        System.out.println(max);
    }
}

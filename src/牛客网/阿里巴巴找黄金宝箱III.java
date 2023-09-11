package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字。
 * 阿里巴巴念出一个咒语数字，查看宝箱是否存在两个不同箱子，这两个箱子上贴的数字相同，
 * 同时这两个箱子的编号之差的绝对值小于等于咒语数字，
 * 如果存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1。
 *
 * 输入描述
 *
 * 第一行输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1
 * 字串中数字个数>=1，<=100000；每个数字值>=-100000，<=100000；
 * 第二行输入咒语数字，例如：3，咒语数字>=1，<=100000
 *
 * 输出描述
 *
 * 存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1。
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 6,3,1,6
 * 3
 * 输出
 *
 * 1
 */
public class 阿里巴巴找黄金宝箱III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //箱子上的数字数组。索引表示其编号
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        //咒语数
        int n = sc.nextInt();
        //是否找到箱子
        boolean flag = false;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            //左侧箱子
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                //右侧箱子
                int right = nums[j];
                if (left == right && j - i <= n) {
                    //两个箱子的数字相同且编号小于等于咒语数，符合要求
                    flag = true;
                    break;
                }
            }
            if (flag) {
                //找到了，记录左侧箱子的编号，并退出循环
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}

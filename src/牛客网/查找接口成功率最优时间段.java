package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，
 *
 * 数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
 *
 * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，
 *
 * 找出数组中最长时间段，如果未找到则直接返回NULL。
 * 输入描述
 *
 * 输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(” “)分隔，
 *
 * minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
 *
 * 输出描述
 *
 * 找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，
 *
 * 如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(” “)拼接，多个下标对按下标从小到大排序。
 *
 * 输入
 *
 * 2
 *
 * 0 0 100 2 2 99 0 2
 *
 * 输出
 *
 * 0-1 3-4 6-7
 */
public class 查找接口成功率最优时间段 {
    private static List<String> sResultList = new ArrayList<>();
    private static int sCurrentLength = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            /*平均最小值*/
            int minAvg = Integer.parseInt(scanner.nextLine().trim());
            /*数组*/
            String[] strings = scanner.nextLine().trim().split(" ");
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < strings.length; i++) {
                list.add(Integer.parseInt(strings[i]));
            }
            getPeriod(minAvg, list);
            /*打印结果*/
            if (!sResultList.isEmpty()) {
                for (int i = 0; i < sResultList.size(); i++) {
                    System.out.print(sResultList.get(i));
                    System.out.print(" ");
                }
            }
        }
    }
    private static void getPeriod(int minAvg, List<Integer> list) {
        sResultList.clear();
        sCurrentLength = 0;
        /*2层循环求和比较*/
        for (int start = 0; start < list.size() - 1; start++) {
            for (int end  = start + 1; end < list.size(); end++) {
                int sum = getSum(list, start, end);
                String result = "";
                /*区间长度*/
                int length = end - start + 1;
                /*满足条件*/
                if (sum == 0 && minAvg >= 0) {
                    result = start + "-" + end;
                } else {
                    /*平均值<=minAvg,满足条件*/
                    if (sum <= minAvg * length) {
                        result = start + "-" + end;
                    }
                }
                /*说明有满足的区间*/
                if (result.contains("-")) {
                    /*区间长度和最大的一样，添加进去*/
                    if (length == sCurrentLength) {
                        sResultList.add(result);
                    }
                    /*有更长的区间，添加到结果集，并清空旧数组，添加新区间*/
                    if (length > sCurrentLength) {
                        sResultList.clear();
                        sResultList.add(result);
                        sCurrentLength = length;
                    }
                }
            }
        }
    }
    /*区间求和*/
    private static int getSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}

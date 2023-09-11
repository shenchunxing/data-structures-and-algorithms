package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 给定一个数组X和正整数K，请找出使表达式X[i] – X[i + 1] –   … –  X[i + K – 1]结果最接近于数组中位数的下标i，如果有多个i满足条件，请返回最大的i。
 *
 * 其中，数组中位数：长度为N的数组，按照元素的值大小升序排列后，下标为N/2元素的值
 * .题目的排序数组X[N]的中位数是X[N/2]。
 */
public class 计算最接近的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*分离出数组X和K*/
        String[] strings = sc.nextLine().replace("[", "")
                .replace("]", "")
                .split(",");
        //最后一个是K值，所以数组长度需要 -1
        int N = strings.length - 1;
        int[] nums = new int[N];
        int K = Integer.parseInt(strings[N]);
        /*转成int数组*/
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        //原数组需要拷贝一下求中位数
        int[] numsCopy = Arrays.copyOf(nums, N);
        /*升序排序*/
        Arrays.sort(numsCopy);
        //中位数为 N/2 位置的数
        int mid = numsCopy[N / 2];
        int min = Integer.MAX_VALUE;
        //最终的索引
        int index = -1;
        /*按照题意X[i] – X[i + 1] –   … –  X[i + K – 1]*/
        for (int i = 0; i <= N - K; i++) {
            int count = nums[i];
            for (int j = i + 1; j < i + K; j++) {
                count -= nums[j];
            }
            //求计算结果与中位数的距离
            int abs = Math.abs(count - mid);
            /*求较小值，说明更接近*/
            min = Math.min(min, abs);
            /*如果相等了，说明存在重复，因为i在++，所以更新index = i*/
            if (min == abs) {
                //只要此次满足最小距离就更新坐标（因为题目要求最大索引）
                index = i;
            }
        }
        System.out.println(index);
    }
}

package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 游戏里面，队伍通过匹配实力相近的对手进行对战。但是如果匹配的队伍实力相差太大，对于双方游戏体验都不会太好。
 * 给定n个队伍的实力值，对其进行两两实力匹配，两支队伍实例差距在允许的最大差距d内，则可以匹配。
 * 要求在匹配队伍最多的情况下匹配出的各组实力差距的总和最小。
 * 输入描述
 *
 * 第一行，n，d。队伍个数n。允许的最大实力差距d。
 * 2 <= n <= 50
 * 0 <= d <= 100
 *
 * 输出描述
 *
 * 匹配后，各组对战的实力差值的总和。若没有队伍可以匹配，则输出-1。
 *
 * 输入：
 * 6 30
 * 81 87 47 59 81 18
 *
 * 输出：
 * 57
 */
public class 最佳对手 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*队伍数*/
        int n = sc.nextInt();
        /*实力允许的最大差距*/
        int d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getResult(n, d, arr));
    }

    public static int getResult(int n, int d, int[] arr) {
        /*排序*/
        Arrays.sort(arr);
        int odd_count = 0;
        int odd_total = 0;
        int even_count = 0;
        int even_total = 0;
        boolean flag = true;

        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            /*差距在范围内*/
            if (diff <= d) {
                flag = false;
                /*分别统计偶数和奇数，分别求和*/
                if (i % 2 == 0) {
                    odd_count++;
                    odd_total += diff;
                } else {
                    even_count++;
                    even_total += diff;
                }
            }
        }
        /*差距太大，无法匹配，返回-1*/
        if (flag) {
            return -1;
        }
        /*在匹配队伍最多的情况下匹配出的各组实力差距的总和最小*/
        if (odd_count > even_count) {
            return odd_total;
        }
        if (odd_count < even_count) {
            return even_total;
        }
        return Math.min(odd_total, even_total);
    }
}

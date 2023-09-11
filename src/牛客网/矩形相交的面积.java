package 牛客网;

import java.util.Scanner;

/**
 * 求3组坐标构成的矩形区域重合部分的面积。
 *
 * 输入
 *
 * 1 6 4 4
 *
 * 3 5 3 4
 *
 * 0 3 7 3
 *
 * 输出
 *
 * 2
 */
public class 矩形相交的面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            c[i] = sc.nextInt();
        }
        int top = Math.min(a[1], Math.min(b[1], c[1]));
        int left = Math.max(a[0], Math.max(b[0], c[0]));
        int down = Math.max(a[1] - a[3], Math.max(b[1] - b[3], c[1] - c[3]));
        int right = Math.min(a[0] + a[2], Math.min(b[0] + b[2], c[0] + c[2]));
        /*其实就是求上下的最小距离和左右的最小距离相乘*/
        int res = (top - down) * (right - left);
        System.out.println(Math.max(res, 0));
    }
}

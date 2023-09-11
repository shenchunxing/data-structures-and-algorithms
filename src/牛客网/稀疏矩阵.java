package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 如果某一行或者某一列内，存在连续出现的0的个数超过了行宽或者列宽的一半W/2，
 * 则认为该行或者该列是稀疏的。
 * 扫描给定的矩阵，输出稀疏的行数和列数。
 *
 * 输入描述
 *
 * 第一行输入为M和N,表示矩阵的大小M*N，0<M<500, 0<N<100。
 * 接卜来M行输入为矩阵的成员，每行N个成员，
 * 矩阵成员都是有符号整数，范围-32,768到32,767。
 *
 * 输出描述
 *
 * 排序后的编号列表，编号之间以空格分隔
 *
 * 输入
 * 3 3
 * 1 0 0
 * 0 1 0
 * 0 0 1
 *
 * 输出
 * 3
 * 3
 */
public class 稀疏矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        /*统计每行每列0的个数*/
        int[] rowZeroCount = new int[m];
        int[] colZeroCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*记录当前位置的0个数*/
                if (sc.nextInt() == 0) {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
            }
        }
        System.out.println(Arrays.stream(rowZeroCount).filter(val -> val >= n / 2).count());
        System.out.println(Arrays.stream(colZeroCount).filter(val -> val >= m / 2).count());
    }
}

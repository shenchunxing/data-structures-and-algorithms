package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 有若干个文件，使用刻录光盘的方式进行备份，假设每张光盘的容量是500MB，求使用光盘最少的文件分布方式。
 * 所有文件的大小都是整数的MB，且不超过500MB；文件不能分割、分卷打包。
 *
 * 输入描述
 *
 * 一组文件大小的数据
 *
 * 输出描述
 *
 * 使用光盘的数量
 *
 * 输入
 *
 * 100,500,300,200,400
 * 输出
 *
 * 3
 */
public class 数据最节约的备份方法 {
    /*不懂*/
    public static int[] files;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        files = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        /*从小到大排序*/
        Arrays.sort(files);
        int min = 0;
        int max = files.length + 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (check(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
    public static boolean check(int mid) {
        int[] ints = new int[mid];
        for (int i = 0; i < mid; i++) {
            ints[i] = 500;
        }
        for (int i = files.length - 1; i >= 0; i--) {
            int f = files[i];
            Arrays.sort(ints);
            if (ints[mid - 1] >= f) {
                ints[mid - 1] -= f;
            } else {
                return false;
            }
        }
        return true;
    }
}

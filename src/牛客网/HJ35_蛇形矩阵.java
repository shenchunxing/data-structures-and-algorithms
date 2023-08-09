package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 */
public class HJ35_蛇形矩阵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str), count = 0, first = 1;
            for (int i = 0; i < num; i++) {
                /*每一层的第一个数是1 2 4 7，加的是i*/
                first += i;
                /*添加每层第一个数,后面的数需要以此为基准递增*/
                count = first;
                /*每个数字后加一个空格*/
                sb.append(count).append(' ');
                /*每排除了第一个数后，剩下需要添加的个数 = num - i - 2 + 1*/
                for (int j = i + 2; j <= num; j++) {
                    /*递增的基数是j*/
                    count += j;
                    sb.append(count).append(' ');
                }
                /*每一层换行*/
                sb.append("\n");
            }
            System.out.print(sb);
            sb.delete(0, sb.length());
        }
    }
}

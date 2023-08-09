package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 *
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 输入一个正整数n。
 *
 * 输出描述：
 * 输出一个相加后的整数。
 */
public class HJ100_等差数列 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while ((message = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(message);
            int an = 3*n-1;
            int a1 = 2;
            /*套公式：（d * n - 1）* 2 /2  */
            System.out.println((a1+an)*n/2);
        }
    }
}

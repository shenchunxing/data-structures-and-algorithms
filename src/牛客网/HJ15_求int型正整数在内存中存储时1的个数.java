package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 */
public class HJ15_求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();    //读取数字
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n = n >>> 1;//java无符号右移 >>>
        }
        System.out.println(ans);
    }
}

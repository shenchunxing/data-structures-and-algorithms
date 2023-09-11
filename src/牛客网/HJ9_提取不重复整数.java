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
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 */
public class HJ9_提取不重复整数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        /*读取每个字符，并存到字符数组中*/
        char[] chars = s.toCharArray();
        /*翻转*/
        reverse(0,chars.length - 1,chars);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            /*检查result中是否已经存在当前字符，如果已经存在，则继续下一个循环迭代，跳过当前字符的处理*/
            /*lastIndexOf函数查找在result中最后一次出现某字符/字符串的位置*/
            /*！=-1表示已经存在*/
            String c = String.valueOf(chars[i]);
            if (result.lastIndexOf(c) != -1){
                continue;
            }
            result.append(chars[i]);
        }
        System.out.println(result.toString());
    }

    private static void reverse(int start, int end, char[] chars) {
        while (start < end) {
            // 交换首尾字符
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // 移动索引
            start++;
            end--;
        }
    }
}

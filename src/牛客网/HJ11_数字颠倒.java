package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class HJ11_数字颠倒 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = s.length();
        char[] chars = s.toCharArray();
        reverse(0,n- 1,chars);
        System.out.println(chars);
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

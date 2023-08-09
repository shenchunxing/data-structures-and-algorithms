package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：1\le |s|\le 250\1≤∣s∣≤250
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 */
public class HJ84_统计大写字母个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            char[] chars = str.toCharArray();
            int count = 0;
            for(int i = 0; i < chars.length; i++)
                if(65 <= chars[i] && chars[i] <= 90) count ++;
            System.out.println(count);
        }
    }
}

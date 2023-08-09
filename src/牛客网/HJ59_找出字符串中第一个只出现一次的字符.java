package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 找出字符串中第一个只出现一次的字符
 */
public class HJ59_找出字符串中第一个只出现一次的字符 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                /*如果第一次出现的位置和最后一次出现的位置是同一个位置，说明只出现了一次*/
                if (input.indexOf(c) == input.lastIndexOf(c)) {
                    System.out.println(c);
                    break;
                }
                /*如果到达结尾了，说明没有，返回-1*/
                if (i == input.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
    }
}

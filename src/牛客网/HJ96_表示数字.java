package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 */
public class HJ96_表示数字 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null){
            char[] c = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < c.length){
                /*如果是数字，头尾拼接'*'*/
                if (c[i] >= '0' && c[i] <= '9'){
                    sb.append("*");
                    sb.append(c[i]);
                    /*然后继续扫描，如果是数字继续拼接*/
                    while(++i < c.length && c[i] >= '0' && c[i] <= '9'){
                        sb.append(c[i]);
                    }
                    sb.append("*");
                }else{
                    /*如果不是数字，正常拼接就行*/
                    sb.append(c[i]);
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}

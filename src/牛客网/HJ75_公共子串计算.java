package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：
 * 1
 * ≤
 * s
 * ≤
 * 150
 *
 * 1≤s≤150
 * 进阶：时间复杂度：
 * O
 * (
 * n
 * 3
 * )
 *
 * O(n
 * 3
 *  ) ，空间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n)
 */
public class HJ75_公共子串计算 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while((str1 = bf.readLine())!= null && (str2 = bf.readLine())!= null){
            int max = 0;
            char[] cha1 = str1.toCharArray();
            char[] cha2 = str2.toCharArray();
            for(int i = 0; i < str1.length(); i++){
                for(int j = 0; j < str2.length(); j++){
                    int t1 = i;
                    int t2 = j;
                    int count = 0;
                    /*如果当期字符相等，则继续匹配，直到其中一个字符串遍历结束，并实时更新最大值*/
                    while(cha1[t1] == cha2[t2]){
                        t1++;
                        t2++;
                        count++;
                        max = Math.max(count,max);
                        if(t1 == cha1.length || t2 == cha2.length) break;
                    }
                }
            }
            System.out.println(max);
        }
    }
}

package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:
 * 1
 * ≤
 * l
 * e
 * n
 * (
 * S
 * )
 * ,
 * l
 * e
 * n
 * (
 * T
 * )
 * ≤
 * 200
 *
 * 1≤len(S),len(T)≤200
 * 进阶：时间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n) ，空间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n)
 * 输入描述：
 *
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 输出描述：
 *
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 */
public class HJ81_字符串字符匹配 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        String str2="";
        while((str=br.readLine())!=null&&!"".equals(str)){
            str2=br.readLine();
            /*短字符串数组*/
            char[] arr=str.toCharArray();
            boolean judge=true;
            /*遍历短字符串数组的每个字符，如果有不包含的字符，直接false*/
            for(char c:arr){
                if(!str2.contains(String.valueOf(c))){
                    judge=false;
                    break;
                }
            }
            System.out.println(judge);
        }
        br.close();
    }
}

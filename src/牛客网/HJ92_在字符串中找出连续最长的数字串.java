package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 数据范围：字符串长度
 * 1
 * ≤
 * n
 * ≤
 * 200
 *
 * 1≤n≤200  ， 保证每组输入都至少含有一个数字
 * 输入描述：
 *
 * 输入一个字符串。1<=len(字符串)<=200
 * 输出描述：
 *
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 */
public class HJ92_在字符串中找出连续最长的数字串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        while((str=br.readLine())!=null){
            char[] chars=str.toCharArray();
            int max=0;
            String res=null;
            for(int i=0;i<chars.length;i++){
                /*如果是数字*/
                if(chars[i]>='0' && chars[i]<='9'){
                    /*start表示最长数字串的起始位置*/
                    int start=i;
                    while(i<chars.length && chars[i]>='0' && chars[i]<='9'){
                        i++;
                    }
                    /*得到长度*/
                    int len=i-start;
                    /*如果发现更长的子串，更新*/
                    if(len>max){
                        max=len;
                        res=str.substring(start,i);
                        /*如果长度和最大值相等，拼接到res上*/
                    }else if(len==max){
                        max=len;
                        res=res+str.substring(start,i);
                    }
                }
            }
            System.out.println(res+","+max);
        }
    }
}

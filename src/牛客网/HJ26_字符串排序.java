package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 */
public class HJ26_字符串排序 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine())!=null){
            char[] ch =line.toCharArray();
            char[] cop = new char[ch.length];
            int offset = 0;
            for(int i='A';i<='Z';i++){
                for(int j=0;j<ch.length;j++){
                    /*将每个字母都记录到数组中，注意外层循环从'A'到'Z'，其实就是在排序了*/
                    /*保存的是按照字母从小到大排序的，大小写按照原来的顺序排布的*/
                    if(ch[j] == i || ch[j]-(char)32 == i){
                        cop[offset++]=ch[j];
                    }
                }
            }
            offset = 0;
            /*cop只记录了字母的位置和值，并不包括非字母*/
            /*这里这么做是为了非字母也可以填充进去*/
            for(int i=0;i<ch.length;i++){
                if((ch[i]>='A' && ch[i]<='Z')||(ch[i]>='a'&&ch[i]<='z')){
                    ch[i] = cop[offset++];
                }
            }
            System.out.println(String.valueOf(ch));
        }
    }
}

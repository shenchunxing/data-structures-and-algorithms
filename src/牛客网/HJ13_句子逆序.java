package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class HJ13_句子逆序 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            char[] strArr = str.toCharArray();
            /*先所有字符全部翻转*/
            recerseString(strArr,0,strArr.length - 1);
            /*再将单词翻转*/
            reverseWord(strArr);
            System.out.println(new String(strArr));
        }
    }
    /*反转指定区间的字符*/
    private static void recerseString (char[] str, int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }
    }
    /*翻转单词*/
    private static void reverseWord(char[] str){
        int i = 0;
        int j = 0;
        while(j < str.length){
            /*扫描字符，直到遇到空格 或者 直接扫描结束*/
            while( j < str.length && str[j] != ' '){
                j++;
            }
            /*翻转第一个单词，j目前处于空格位置*/
            if(j != 0){
                recerseString(str, i, j - 1);
            }
            /*j处于空格位置，需要跳过空格（可能有连续多个空格），直到遇到字符，作为下一个单词的开头*/
            while(j < str.length && str[j] == ' '){
                j++;
            }
            /*新单词的起始位置*/
            i = j;
        }

    }
}


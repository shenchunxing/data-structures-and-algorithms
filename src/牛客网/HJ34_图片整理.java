package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 一行，一个字符串，字符串中的每个字符表示一张Lily使用的图片。Lily的所有图片按照从小到大的顺序输出
 * 输入：Ihave1nose2hands10fingers
 * 输出：0112Iaadeeefghhinnnorsssv
 */
public class HJ34_图片整理 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s=br.readLine())!=null){
            /*转成字符数组*/
            char[] result = s.toCharArray();
            /*排序*/
            Arrays.sort(result);
            System.out.println(String.valueOf(result));
        }
    }
}

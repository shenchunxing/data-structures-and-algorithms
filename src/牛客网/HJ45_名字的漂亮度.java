package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 描述
 * 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 数据范围：输入的名字长度满足 1 \le n \le 10000 \1≤n≤10000
 *
 * 输入描述：
 * 第一行一个整数N，接下来N行每行一个字符串
 *
 * 输出描述：
 * 每个字符串可能的最大漂亮程度
 *
 * 示例1
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 复制
 * 输出：
 * 192
 * 101
 * 复制
 * 说明：
 * 对于样例lisi，让i的漂亮度为26，l的漂亮度为25，s的漂亮度为24，lisi的漂亮度为25+26+24+26=101.
 */
public class HJ45_名字的漂亮度 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            /*输入的字符串个数*/
            int n=in.nextInt();
            for(int i=0;i<n;i++){
                String str=in.next();
                int s[]=new int[128];
                /*统计字符个数*/
                for(int j=0;j<str.length();j++){
                    s[str.charAt(j)]++;
                }
                /*排序，从小到大*/
                Arrays.sort(s);
                int mul=26,sum=0;
                /*遍历的时候倒序，从大到小*/
                /*空字符跳过s[j]>0*/
                for(int j=s.length-1;j>=0&&s[j]>0;j--){
                    /*最大26，最小1*/
                    sum+=s[j]*mul;
                    mul--;
                }
                System.out.println(sum);
            }
        }
    }
}

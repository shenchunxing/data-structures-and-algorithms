package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 */
public class HJ65_查找两个字符串ab中的最长公共子串 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while((string = reader.readLine()) != null){
            System.out.println(longestCommonSub(string,reader.readLine()));
        }
    }

    private static String longestCommonSub(String a, String b) {
        /*确保a是较小的那个字符串*/
        if(a.length() > b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int len1 = a.length(),len2 = b.length();
        /*dp[i][j]是在[i,j]范围内最长的公共子串*/
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0,start = 0;
        for(int i = 1;i <= len1;++i){
            for(int j = 1;j <= len2;++j){
                /*如果字符匹配*/
                if (A[i - 1] == B[j - 1]) {
                    /*记录*/
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    /*更新最大值和起始坐标*/
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        start = i - 1 - max;
                    }
                }
            }
        }
        /*返回最长公共子串*/
        return a.substring(start + 1,1 + start + max);
    }
}

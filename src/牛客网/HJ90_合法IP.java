package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 * 现在需要你用程序来判断IP是否合法。
 *
 * 数据范围：数据组数：
 * 1
 * ≤
 * t
 * ≤
 * 18
 *
 * 1≤t≤18
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
 *
 * 输入描述：
 *
 * 输入一个ip地址，保证不包含空格
 * 输出描述：
 *
 * 返回判断的结果YES or NO
 */
public class HJ90_合法IP {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = bf.readLine()) != null){
            /*根据'.'分割*/
            String[] subIP = str.split("\\.");
            for(int i =0; i < subIP.length; i++){
                Integer intIP = Integer.valueOf(subIP[i]);
                /*判断范围*/
                if(intIP >= 0 && intIP<=255){
                    /*已经到最后一个字符串了，说明完全匹配了*/
                    if(i == subIP.length-1){
                        System.out.println("YES");
                    }
                    continue;
                } else{
                    System.out.println("NO");
                    /*有一个不匹配，直接false*/
                    break;
                }
            }
        }
    }
}

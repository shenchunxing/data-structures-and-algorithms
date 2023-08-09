package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5 ，1\le n\le 500000\1≤n≤500000
 * 进阶：时间复杂度：O(logn)\O(logn) ，空间复杂度：O(1)\O(1)
 */
public class HJ86_求最大连续bit数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            int res = 0;
            /*表示连续1的个数*/
            int zere = 0;
            //一直取最后一位，
            while(n != 0){
                if(n % 2 == 1){
                    zere++;
                    /*如果连续1的个数比答案大，更新答案*/
                    if(zere > res){
                        res = zere;
                    }
                }else{
                    /*如果不是1，则中断了，置为0*/
                    zere = 0;
                }
                /*每次取一半，相当于右移一位*/
                n /= 2;
            }
            System.out.println(res);
        }
    }
}

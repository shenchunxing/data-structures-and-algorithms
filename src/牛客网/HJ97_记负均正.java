package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
 *
 * 数据范围：
 * 1
 * ≤
 * n
 *
 * ≤
 * 2000
 *
 * 1≤n ≤2000  ，输入的整数都满足
 * ∣
 * v
 * a
 * l
 * ∣
 * ≤
 * 1000
 *
 * ∣val∣≤1000
 * 输入描述：
 *
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * 输出描述：
 *
 * 输出负数的个数，和所有正整数的平均值。
 */
public class HJ97_记负均正 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            int n =  Integer.parseInt(str);
            String[] nums=br.readLine().split(" ");
            /*负数数量*/
            int negative=0;
            /*正数数量*/
            int positive=0;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                int num=Integer.parseInt(nums[i]);
                if(num<0){
                    negative++;
                }else if(num>0){
                    sum+=num;
                    positive++;
                }
            }

            /*int转double，并保留一位小数 Math.round(sum*10.0/positive)/10.0*/
            System.out.println(negative+" "+Math.round(sum*10.0/positive)/10.0);

        }
    }
}

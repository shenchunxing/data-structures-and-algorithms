package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n) ，空间复杂度：
 * O
 * (
 * 1
 * )
 *
 * O(1)
 */
public class HJ73_计算日期到天数转换 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        while((str=br.readLine())!=null){
            String [] strs=str.split(" ");
            int year=Integer.parseInt(strs[0]);
            int month=Integer.parseInt(strs[1]);
            int day=Integer.parseInt(strs[2]);
            int result=day;
            for(int i=1;i<month;i++){
                result=result+getMonthDays(year,i);
            }
            System.out.println(result);
        }
    }
    public static int getMonthDays(int year,int month){
        /*大月*/
        if(month==1 ||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        /*是否是闰月*/
        if(month==2){
            return(year%4==0 && year%100!=0) ?29:28;
        }
        /*小月*/
        return 30;
    }
}

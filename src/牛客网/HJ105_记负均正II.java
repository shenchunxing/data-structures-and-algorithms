package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * 输入描述:
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 */
public class HJ105_记负均正II {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int count=0, total=0, countNot = 0;
        while((str =reader.readLine())!=null){
            int num = Integer.valueOf(str);
            if(num < 0){
                /*负数次数*/
                count++;
            }else {
                /*非负数求和*/
                total+= num;
                /*非负数次数*/
                countNot++;
            }
        }
        System.out.println(count);
        /*没有非负数，打印0*/
        if(countNot==0){
            System.out.println(0.0);
        }else{
            /*取平均值*/
            /*Math.round四舍五入，2.5会变成3*/
            long round = Math.round(total * 10.0 / countNot);
            System.out.println(round/10+"."+round%10);
        }
    }
}

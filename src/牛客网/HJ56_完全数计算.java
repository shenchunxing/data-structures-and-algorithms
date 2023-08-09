package 牛客网;

import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 */
public class HJ56_完全数计算 {
    /*完全数计算*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        int sum=0;
        for(int i=1;i<=num;i++){
            /*判断函数i是否等于计算结果*/
            if(getResult(i)==i){
                sum++;
            }
        }
        System.out.print(sum);
    }
    public static int getResult(int num){
        int sum=0;
        for(int i=1;i<num;i++){
            /*累加每一个因数*/
            if(num%i==0){
                sum+=i;
            }
        }
        return sum;
    }
}

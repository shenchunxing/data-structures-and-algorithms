package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 */
public class HJ37_统计每个月兔子的总数 {
    /*其实就是斐波那契数列*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }
    public static int dp(int n){
        int num1 = 1,num2 = 1;
        if (n <= 2) return 1;
        int count = 0;
        for(int i=3;i<=n;i++){
           int temp = num2;
           num2 += num1;
           num1 = temp;
        }
        return num2;
    }
}

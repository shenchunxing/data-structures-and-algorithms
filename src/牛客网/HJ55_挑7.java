package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 */
public class HJ55_挑7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = bufferedReader.readLine()) != null) {
            int count=0;
            int num=Integer.parseInt(input);
            /*直接从7开始*/
            for(int i=7;i<=num;i++){
                /*可以除尽7或者包含7*/
                if(i%7==0||contain7(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean contain7(int n) {
        while (n > 0) {
            /*比如173这种包含7*/
            if (n % 10 == 7) {
                return true;
            } else {
                /*不断取最后1位数来判断是否包含7*/
                n /= 10;
            }
        }
        return false;
    }
}

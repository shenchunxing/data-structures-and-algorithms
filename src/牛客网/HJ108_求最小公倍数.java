package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 */
public class HJ108_求最小公倍数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            /*按照空格分离开*/
            String[] strArr = str.split(" ");
            /*获取两个int值*/
            int n = Integer.parseInt(strArr[0]);
            int m = Integer.parseInt(strArr[1]);
            int j = m*n;
            /*确保n是较小的那个，m是较大的那个*/
            if(n>m){
                int temp = m;
                m = n;
                n =temp;
            }
            //先求最大公约数
            while(n!=0){
                int r = m%n;
                m = n;
                n = r;
            }
            /*最小公倍数 = 两数乘积 / 最大公约数*/
            int max = j/m;
            System.out.println(max);
        }
    }
}

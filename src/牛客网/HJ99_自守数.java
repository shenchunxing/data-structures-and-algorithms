package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n(包括n)以内的自守数的个数
 *
 * 数据范围：
 * 1
 * ≤
 * n
 * ≤
 * 10000
 *
 * 1≤n≤10000
 *
 *
 * 输入描述：
 *
 * int型整数
 * 输出描述：
 *
 * n以内自守数的数量。
 */
public class HJ99_自守数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int n=Integer.valueOf(str);
            int count=0;
            for(int i=0;i<=n;i++){
                int temp=i;
                int j=1;
                /*计算需要的10的平方数，如果i = 25.则j = 100，i有多少位，10的平方就有多少个乘积*/
                while(temp!=0){
                    temp=temp/10;
                    j=j*10;
                }
                /*满足条件：i^2 - i是10的倍数   25^2 = 625,625 - 25 = 600是100的倍数*/
                if((i*i-i)%j==0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ6_质数因子 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            /*i^2 <= num*/
            for (int i = 2; i <= Math.sqrt(num); i++) {
                /*可以除尽的就是质因子*/
                if (num % i == 0) {
                    sb.append(i).append(" ");
                    num = num / i;
                    /*这里i--是因为，默认循环i每次都++，这里找到了质因子，就继续原地匹配，可能能匹配i，比如180第一个质因子是2，第二个还是2*/
                    i--;
                }
            }
            /*如17，不会进入上面的过程，还是保留了num = 17*/
            sb.append(num).append(" ");
            System.out.println(sb.toString());
        }
    }
}

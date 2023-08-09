package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输出该字符串反转后的字符串
 */
public class HJ12_字符串反转 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(reader);
        String str = br.readLine();
        char[] c=str.toCharArray();
        for (int i=c.length-1;i>=0;i--){
            System.out.print(c[i]);
        }
    }
}

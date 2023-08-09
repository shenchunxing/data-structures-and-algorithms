package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输出该字符串反转后的字符串
 */
public class HJ46_截取字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res;
        int len;
        while ((res = br.readLine())!= null) {
            /*获取字符串长度*/
            len = Integer.parseInt(br.readLine());
            /*截取*/
            System.out.println(res.substring(0, len));
        }
    }
}

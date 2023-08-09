package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输出该字符串反转后的字符串
 */
public class HJ14_字符串排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        /*行数*/
        int count=Integer.parseInt(bf.readLine());
        String[] result=new String[count];
        /*读一行，保存一行*/
        for(int i=0;i<count;i++)result[i]=bf.readLine();
        StringBuilder sb=new StringBuilder();
        /*排序*/
        Arrays.sort(result);
        /*拼接打印*/
        for (String w : result) sb.append(w).append('\n');
        System.out.println(sb.toString());
    }
}

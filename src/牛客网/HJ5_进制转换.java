package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 输入：0xAA
 * 输出：170
 */
public class HJ5_进制转换 {
    public static void main(String[] args) throws IOException {
        /*标准输入*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        /*读取整行，并赋值给line变量*/
        while((line = br.readLine()) != null){
            /*'OxA2F'，前面2个'Ox'不需要，截掉，16指的是16进制，返回10进制long类型*/
            System.out.println(Long.parseLong(line.substring(2) , 16));
        }
    }
}

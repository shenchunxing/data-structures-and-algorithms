package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将一个字符串str的内容颠倒过来，并输出。
 * 输入：I am a student
 * 输出：tneduts a ma I
 */
public class HJ106_字符逆序 {
    public static void main(String[] args) throws IOException {
        /*这一行获取标准输入中尚未读取的字节数（available() 方法返回可用于读取的字节数量）。*/
        int length = System.in.available();
        if(length > 2) {
            /*-1是为了排除换行和回车符*/
            byte[] bts = new byte[length-1];
            /*读入字节*/
            int flag = System.in.read(bts);
            /*如果read()方法读取了有效的数据（即未达到输入流的末尾）*/
            if(flag!= -1) {
                byte[] tmp = new byte[bts.length];
                /*逆序输出*/
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = bts[tmp.length - i - 1];
                }
                System.out.println(new String(tmp));
            }

        }
    }
}

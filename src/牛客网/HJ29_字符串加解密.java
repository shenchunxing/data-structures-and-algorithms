package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 对输入的字符串进行加解密，并输出。
 *
 * 加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 解密方法为加密的逆过程。
 */
public class HJ29_字符串加解密 {
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            String word = br.readLine();
            System.out.println(jiami(str));
            System.out.println(jiemi(word));
        }
    }

    /*加密*/
    public static String jiami(String str) {
        char ch[]=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        /*模拟整个过程即可*/
        for(int i=0;i<ch.length;i++) {
            if(ch[i]>='a'&&ch[i]<='z') {
                if(ch[i]=='z')
                    sb.append('A');
                else
                    sb.append((char)(ch[i]-32+1));
            }
            else if(ch[i]>='A'&&ch[i]<='Z') {
                if(ch[i]=='Z')
                    sb.append('a');
                else
                    sb.append((char)(ch[i]+32+1));
            }
            else if(ch[i]>='0'&&ch[i]<='9') {
                if(ch[i]=='9')
                    sb.append('0');
                else
                    sb.append(ch[i]-'0'+1);
            }
        }
        return sb.toString();
    }

    /*解密*/
    public static String jiemi(String str) {
        char ch[]=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++) {
            if(ch[i]>='a'&&ch[i]<='z') {
                if(ch[i]=='a')
                    sb.append('Z');
                else
                    sb.append((char)(ch[i]-32-1));
            }
            else if(ch[i]>='A'&&ch[i]<='Z') {
                if(ch[i]=='A')
                    sb.append('z');
                else
                    sb.append((char)(ch[i]+32-1));
            }
            else if(ch[i]>='0'&&ch[i]<='9') {
                if(ch[i]=='0')
                    sb.append('9');
                else
                    sb.append(ch[i]-'0'-1);
            }
        }
        return sb.toString();
    }
}

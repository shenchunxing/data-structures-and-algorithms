package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 */
public class HJ62_查找输入整数二进制中1的个数 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            String s = Integer.toBinaryString(n);
            int cnt = 0;
            for(char c : s.toCharArray())
                if(c == '1')
                    cnt++;
            System.out.println(cnt);
        }
    }
}

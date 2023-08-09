package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 */
public class HJ85_最长回文子串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            int ans = 0;
            char[] s = str.toCharArray();
            for (int i = 0; i < s.length; i++) {
                /*以i为中心，如cbc这种*/
                ans = Math.max(ans, extension(s, i, i));
                /*以i和i-1为中心，如abba这种*/
                if (i > 0) ans = Math.max(ans, extension(s, i-1, i));
            }
            System.out.println(ans);
        }
    }

    /*扩展中心*/
    public static int extension(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

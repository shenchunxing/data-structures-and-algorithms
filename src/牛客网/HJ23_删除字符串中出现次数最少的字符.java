package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 输入：0xAA
 * 输出：170
 */
public class HJ23_删除字符串中出现次数最少的字符 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            int[] letters = new int[26];
            char[] arr = str.toCharArray();
            /*统计每个字符出现的次数*/
            for(char c : arr) letters[c - 'a']++;
            /*题目要求最多不超过20*/
            int minCount = 20;
            for(int cnt : letters) {
                /*更新最小值*/
                if(cnt > 0 && cnt < minCount) minCount = cnt;
            }
            for(char c : arr){
                /*如果不是最小值，就拼接到结果，否则跳过*/
                if(letters[c - 'a'] == minCount) continue;
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

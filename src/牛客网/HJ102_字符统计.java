package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 *
 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 数据范围：字符串长度满足
 1
 ≤
 l
 e
 n
 (
 s
 t
 r
 )
 ≤
 1000

 1≤len(str)≤1000
 输入描述：

 一个只包含小写英文字母和数字的字符串。
 输出描述：

 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 */
public class HJ102_字符统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            char[] chArr = str.toCharArray();
            int[] temp = new int[150];
            /*填充到统计数组中，temp数组内容是在指定位置记录着该字符出现的次数，其他位置都是0*/
            for(int i=0;i<chArr.length;i++){
                temp[chArr[i]]++;
            }
            int max = 0;
            /*求得最大值max*/
            for(int j=0;j<temp.length;j++){
                if(max<temp[j]){
                    max = temp[j];
                }
            }
            StringBuilder sbf = new StringBuilder();
            /*从大到小，如果max已经为0，可以退出了，因为每次循环max都表示的是最大值*/
            while(max!=0){
                for(int j=0;j<temp.length;j++){
                    /*从出现的次数，从大到小拼接，然后max--*/
                    if(temp[j] == max){
                        sbf.append((char)j);
                    }
                }
                max--;
            }
            System.out.println(sbf.toString());
        }
    }
}

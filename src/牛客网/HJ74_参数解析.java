package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 在命令行输入如下命令：
 * xcopy /s c:\\ d:\\e，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\\
 * 参数4: 字符串d:\\e
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 * 解析规则：
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 数据范围：字符串长度：
 * 1
 * ≤
 * s
 * ≤
 * 1000
 *
 * 1≤s≤1000
 * 进阶：时间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n) ，空间复杂度：
 * O
 * (
 * n
 * )
 *
 * O(n)
 * 输入描述：
 *
 * 输入一行字符串，可以有空格
 * 输出描述：
 *
 * 输出参数个数，分解后的参数，每个参数都独占一行
 */
public class HJ74_参数解析 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            char[] cha = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            int flag = 0;
            /*统计参数个数*/
            int count = 1;
            for (int i = 0; i < cha.length; ++i) {
                /*如果是双引号，注意写法*/
                if (cha[i] == '\"') {
                    flag++;
                    continue;
                }
                /*非空格字符，添加*/
                if (cha[i] != ' ') {
                    sb.append(cha[i]);
                }
                /*参数内部的空格，需要添加*/
                if (cha[i] == ' ' && flag % 2 != 0) {
                    sb.append(cha[i]);
                }
                /*区分参数的空格*/
                if (cha[i] == ' ' && flag % 2 == 0) {
                    sb.append("\n");
                    ++count;
                }
            }
            System.out.println(count + "\n" + sb.toString());
        }
    }
}

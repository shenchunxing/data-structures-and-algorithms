package 牛客网;

import java.io.IOException;
import java.io.InputStream;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 */
public class HJ9_提取不重复整数 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        /*-1表示不需要换行符和回车符*/
        int available = in.available()-1;
        /*读取每个字符，并存到字符数组中*/
        char[] chars = new char[available];
        /*倒序加入数组*/
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            /*检查result中是否已经存在当前字符，如果已经存在，则继续下一个循环迭代，跳过当前字符的处理*/
            /*lastIndexOf函数查找在result中最后一次出现某字符/字符串的位置*/
            /*！=-1表示已经存在*/
            String c = String.valueOf(chars[i]);
            if (result.lastIndexOf(c) != -1){
                continue;
            }
            result.append(chars[i]);
        }
        System.out.println(result.toString());
    }
}

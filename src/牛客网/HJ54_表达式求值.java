package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 */
public class HJ54_表达式求值 {
    /*位置*/
    static int pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null) {
            pos = 0;
            int num = compute(str);
            System.out.println(num);
        }
    }

    /*传入一个字符串，返回一个计算值*/
    /*不理解*/
    public static int compute(String s) {
        int len = s.length();
        int[] stack = new int[1000];
        int num = 0;
        int top = 0;
        /*默认操作符'+'*/
        char op = '+';

        while(pos < len) {
            /*如果是左括号*/
            if(s.charAt(pos) == '{' || s.charAt(pos) == '[' || s.charAt(pos) == '(') {
                pos++;
                num = compute(s);
            }
            /*如果是数字*/
            while(pos < len && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                num = num*10 + s.charAt(pos) - '0';
                pos++;
            }
            /*如果是操作符*/
            switch(op) {
                case '+':
                    stack[top++] += num;
                    break;
                case '-':
                    stack[top++] -= num;
                    break;
                case '*':
                    stack[top-1] *= num;
                    break;
                case '/':
                    stack[top-1] /= num;
                    break;
            }
            /*位置已经到结尾了*/
            if(pos == len) {
                break;
            }
            num = 0;
            op = s.charAt(pos);
            /*当前括号内的表达式已经计算完成，跳出循环，返回上一级递归*/
            if (s.charAt(pos) == '}' || s.charAt(pos) == ']'|| s.charAt(pos) == ')') {
                pos++;
                break;
            }
            pos++;
        }
        /*取出数组里面所有存储的值求和*/
        int res = 0;
        for(int i = 0; i < top; i++) {
            res += stack[i];
        }
        return res;
    }
}

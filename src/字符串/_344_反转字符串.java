package 字符串;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-string/
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
/*2023-7-4*/
public class _344_反转字符串 {
    public static void main(String[] args) {
        char[] charts = new char[] {'h','e','l','l','o'};
        reverseString(charts);
        System.out.println(charts);
    }
    /*首尾交换*/
   static public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0 ,r = s.length - 1;
        while (l < r) {
            swap(l++,r--,s);
        }
    }

    static private void swap(int a , int b, char[] chars) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}

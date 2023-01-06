package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class _6_Z字形变换 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
    //O(n) O(n)
   static public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        //创建多个builder，用于存储每一行的字符
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0 , flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c); //将当前字符保存到当前行的builder中
            if (i == 0  || i == numRows - 1) { //如果是第一行或者最后一行，需要调转方向
                flag = -flag;
            }
            i += flag; //i根据flag的值递增或者递减
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

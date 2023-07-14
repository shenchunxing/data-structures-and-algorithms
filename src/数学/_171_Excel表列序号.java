package 数学;

import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 难度：简单
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 */
/*2023-7-14*/
public class _171_Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("C"));
        System.out.println(titleToNumber("AB"));//2 + 1 * 26
        System.out.println(titleToNumber("ZY"));// 25 + 26 * 26
    }
	static public int titleToNumber(String columnTitle) {
        int num = 0;
        int  multiple = 1; //系数
       for (int i = columnTitle.length() - 1 ; i>=0;i--) {
    	   int k = columnTitle.charAt(i) - 'A' + 1; //26进制转10进制
    	   num += k * multiple;
    	   multiple *= 26; //每次系数增大26
       }
       return num;
    }
}

import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author shenchunxing
 *
 */
public class _171_Excel表列序号 {

	public int titleToNumber(String columnTitle) {
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

package 排序指针;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/largest-number/
 */
public class _179_最大数 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            strings[i] = String.valueOf(nums[i]); //数字转字符串
        }
        //从大到小排序
        Arrays.sort(strings,new LargerNumberComparator());
        if (strings[0].equals("0")) return "0";

        //拼接
        String largestNumberStr = new String();
        for (String numStr : strings) {
            largestNumberStr += numStr;
        }
        return largestNumberStr;
    }

    //比较器
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1 ;
            return order2.compareTo(order1); //每一对数在排序的比较过程中，我们比较两种连接顺序哪一种更好。
        }
    }
}

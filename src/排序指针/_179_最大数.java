package 排序指针;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/largest-number/
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
/*2023-7-10*/
public class _179_最大数 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {3,30,34,5,9}));//9534330
    }
   static public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        /*因为最后要返回String，直接将nums数组转成string数组*/
        for (int i = 0; i < nums.length; i ++) {
            strings[i] = String.valueOf(nums[i]);
        }
        //从大到小排序
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /*字符串用这种方式比较大小，先比较第一个字符，第一个字符大就大和长度无关。并不是直接比较o1和o2*/
                String order1 = o1 + o2;
                String order2 = o2 + o1 ;
                return order2.compareTo(order1); //每一对数在排序的比较过程中，我们比较两种连接顺序哪一种更好。
            }
        });
        if (strings[0].equals("0")) return "0";

        //将排序后的字符串拼接
        String largestNumberStr = new String();
        for (String numStr : strings) {
            largestNumberStr += numStr;
        }
        return largestNumberStr;
    }
}

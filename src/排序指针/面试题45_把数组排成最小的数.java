package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class 面试题45_把数组排成最小的数 {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[] {10,2}));
        System.out.println(minNumber(new int[] {3,30,34,5,9}));
    }
    //按照题意：需要用string去实现，比较和排序.不能直接用数字
    static public String minNumber(int[] nums) {
        //将数字转成字符串数组
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        //比较规则:字符串从小到大排序:"30" "3" "34" "5" "9"，先比较第一个，相同继续比较
        Arrays.sort(res,(o1,o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        });
        //现在的res是已经排序后的数组了，然后拼接成string就行
        StringBuilder builder = new StringBuilder();
        for (String s : res) {
            builder.append(s);
        }
        return builder.toString();
    }
}

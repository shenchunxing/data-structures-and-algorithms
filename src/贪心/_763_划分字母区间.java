package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/
 * 难度：中等
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 */
/*2023-7-11*/
public class _763_划分字母区间 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
    static public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //记录每个字符最后一次出现的位置
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        /*start和end分别代表左右边界*/
        int start = 0 ,end = 0;
        for (int i = 0; i < length; i++) {
            //查找右边界，比较每个字符出现的位置，以最右的位置为准。
            end = Math.max(end , last[s.charAt(i) - 'a']);
            /*刚好到达了右边界，此时遍历过的值都已经出现全了，此处可以截断，然后重新开始寻找下个右边界*/
            if (end == i) {
                ans.add(end - start + 1);//当前长度
                start = end + 1; //重新开始，左边界改成end + 1
            }
        }
        return ans;
    }
}

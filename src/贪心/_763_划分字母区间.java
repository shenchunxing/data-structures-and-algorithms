package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class _763_划分字母区间 {
    public static void main(String[] args) {
        _763_划分字母区间 o = new _763_划分字母区间();
        System.out.println(o.partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //记录每个字符最后一次出现的位置
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0 ,end = 0;
        for (int i = 0; i < length; i++) {
            //贪心：当前片段的结束下标i肯定>=该字母的最后一次出现的位置end
            end = Math.max(end , last[s.charAt(i) - 'a']);
            if (end == i) { //到达了最后出现该字符的位置
                ans.add(end - start + 1);//当前长度
                start = end + 1; //重新开始
            }
        }
        return ans;
    }
}

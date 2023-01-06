package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 */
public class _438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        _438_找到字符串中所有字母异位词 o = new _438_找到字符串中所有字母异位词();
//        System.out.println(o.findAnagrams("cbaebabacd","abc"));
        System.out.println(o.findAnagrams("deacbefhj","abc"));
    }
    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        if (slen < plen) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] scount = new int[26];
        int[] pcount = new int[26];
        //分别统计字符的数量
        for (int i = 0; i < plen; i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        //整个数组完全匹配，下标是0
        if (Arrays.equals(scount,pcount)) {
            ans.add(0);
        }
        //滑动窗口
        for (int i = 0; i < slen - plen; i++) {
            scount[s.charAt(i) - 'a']--; //找到一个存在的字符，数量-1
            scount[s.charAt(i + plen) - 'a']++; //滑动窗口大小为plen，跳过plen的长度，重新加回来
            if (Arrays.equals(scount,pcount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}

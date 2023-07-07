package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
/*2023-7-7*/
public class 剑指Offer50_第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar2("abaccdeff"));
    }
    //哈希表
    static public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        /*哈希表统计每个字符的出现次数*/
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        /*出现一个只有1次的字符，直接return*/
        for (char c :chars) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }

    //计数。这种只适合只有字母的情况
    static public char firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++; //统计每个字符的数量
        }
        for (char c : chars) {
            int value = count[c - 'a'];
            if (value == 1) return c;
        }
        return ' ';
    }
}

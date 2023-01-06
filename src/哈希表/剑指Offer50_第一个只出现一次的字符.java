package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class 剑指Offer50_第一个只出现一次的字符 {
    //哈希表
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for (char c :chars) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }

    //计数
    public char firstUniqChar2(String s) {
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

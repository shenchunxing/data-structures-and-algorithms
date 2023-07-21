package 哈希表;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/
 * 难度：中等
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class _49_字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    /**
     * O(nklogk) O(nk)
     * 排序：由于互为字母异位词的两个字符串包含的字母相同，故可以将排序之后的字符串作为哈希表的键。
     */
    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();//转成字符数组
            Arrays.sort(array); //排序
            String key = new String(array);//排序后的字符数组作为key
            /*默认是空数组，相同的字母异位词会添加到同一个list中，并保存到哈希表*/
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());//取出map.values就行
    }

    /**
     * 计数
     */
    static public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] counts = new int[26]; //统计字符的数量
            int length = s.length();
            for (int i = 0; i < length; i++) {
                counts[s.charAt(i) - 'a'] ++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            // 原理和排序类似，就是指异或词的key也是相同的。
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    builder.append('a' + i);
                    builder.append(counts[i]);
                }
            }
            String key = builder.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}

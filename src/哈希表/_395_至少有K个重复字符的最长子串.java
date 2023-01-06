package 哈希表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class _395_至少有K个重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb",3));
        System.out.println(longestSubstring("ababbcd",2));
    }

   static public int longestSubstring(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        //记录每个字符出现的次数
        for (char c : chars) {
            map.put(c,map.get(c) == null ? 1 : map.get(c) + 1 );
        }

       //找到不符合条件的字符
        //记录不满足条件的下标，用于切割字符串，分成多个子串。
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) < k) {
                list.add(i);
            }
        }

        //如果都满足条件，直接返回字符串长度
        if (list.size() == 0) return s.length();

        int ans = 0, left = 0 ;
        list.add(s.length());
        for (int i = 0; i < list.size(); i++) {
            //当前字符串的长度
            int len = list.get(i) - left;
            //更新最长长度
            if (len > ans) {
                //最长长度出现在某个被切割的子串中
                ans = Math.max(ans,longestSubstring(s.substring(left,len + left),k));
            }
            //更新计算最长长度的起始位置
            left = list.get(i) + 1;
        }

        return ans;
    }
}

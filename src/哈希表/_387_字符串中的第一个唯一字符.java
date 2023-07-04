package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 */
/*2023-7-4*/
public class _387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    static public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        /*记录每个字符出现的次数*/
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        /*如果只出现一次的，直接返回*/
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

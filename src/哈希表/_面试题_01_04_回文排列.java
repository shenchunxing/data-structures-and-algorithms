package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/palindrome-permutation-lcci/
 */
public class _面试题_01_04_回文排列 {
    public boolean canPermutePalindrome(String s) {
        //因此，某字符串是回文串排列之一的「充要条件」为：此字符串中，最多只有一种字符的出现次数为「奇数」，
        // 其余所有字符的出现次数都为「偶数」
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { //统计每个字符的数量
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        int odd = 0; //奇数个数的数量是否大于1
        for (int value : map.values()) {
            if (value % 2 == 1) {
                odd++;
                if (odd > 1) return false;
            }
        }
        return true;
    }
}

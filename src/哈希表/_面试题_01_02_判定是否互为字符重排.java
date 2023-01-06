package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
public class _面试题_01_02_判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length() , len2 = s2.length();
        if (len1 != len2) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {//s2统计的时候，让字符数量+1
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0) + 1);
        }
        for (int i = 0; i < len2; i++) { //s2统计的时候，让字符数量-1
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0) - 1);
        }
        //最终如果是字符串重排的，应该都是0
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}

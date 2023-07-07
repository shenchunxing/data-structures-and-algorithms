package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/check-permutation-lcci/
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
/*2023-7-7*/
public class _面试题_01_02_判定是否互为字符重排 {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc","bca"));
        System.out.println(CheckPermutation("abc","bad"));
    }
    //O(n)时间复杂度，O(n)空间复杂度
    static public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length() , len2 = s2.length();
        /*长度不相等，直接false*/
        if (len1 != len2) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        /*统计每个字符的数量*/
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

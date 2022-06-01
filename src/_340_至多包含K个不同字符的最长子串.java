import java.util.Collections;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 */
public class _340_至多包含K个不同字符的最长子串 {
    /**
     * 滑动窗口 + 哈希表 + 双指针
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n  = s.length();
        if ( n == 0 || k == 0) return 0;
        int left = 0 , right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max_len = 1;
        while (right < n) {
            map.put(s.charAt(right),right++); //先将right和right的下标记录下
            if (map.size() == k + 1) { //超过了k个不同元素,需要删除最左的字符
                int del_idx = Collections.min(map.values()); //找到value最小的就是最左的下标（因为put的时候，是以right++的形式添加的）
                map.remove(s.charAt(del_idx)); //删除最左的元素，确保只剩下k个元素
                left = del_idx + 1; //移动left
            }
            //更新最大值长度
            max_len = Math.max(max_len,right - left);
        }
        return max_len;
    }
}

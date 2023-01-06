package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class 剑指Offer03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }
}

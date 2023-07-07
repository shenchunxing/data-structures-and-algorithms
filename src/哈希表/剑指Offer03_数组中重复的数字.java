package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
/*2023-7-7*/
public class 剑指Offer03_数组中重复的数字 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }
    static public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }
}

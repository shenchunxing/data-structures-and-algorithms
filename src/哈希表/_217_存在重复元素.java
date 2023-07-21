package 哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate/
 * 数组、哈希表、排序
 */
public class _217_存在重复元素 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,3,5,6,4,2}));
        System.out.println(containsDuplicate(new int[] {1,3,2,6,4,2}));
    }
   static public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true; //HashSet去重
        }
        return false;
    }

    static public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums); //排序比较
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}

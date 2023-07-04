package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */

/*2023-7-4*/
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            /*可以找到下标，说明符合条件*/
            if (index !=  null) return new int[] {index , i};
            /*不符合就记录值和位置*/
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}

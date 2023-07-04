package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
/*2023-7-4*/
public class _219_存在重复元素II {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //哈希表：
    static public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //已经存在下标j && i - j <= k
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }

            //记录每个num的最大下标
            map.put(num, i);
        }
        return false;
    }

    //滑动窗口
    static public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //i >k , 则下标i - k - 1的值移除,每次循环确保滑动窗口大小就是k
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            //如果不能添加成功，说明set里面已经存在相同的值
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}

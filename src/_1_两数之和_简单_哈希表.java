import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class _1_两数之和_简单_哈希表 {
    //哈希表
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        // 用来存放之前扫描过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //从map中查找到符合条件的下标
            Integer idx = map.get(target - nums[i]); 
            if (idx != null) return new int[]{idx, i};
            //每次将下标和值放入map。
            map.put(nums[i], i);
        }
        return null;
    }
}

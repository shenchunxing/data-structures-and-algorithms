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

<<<<<<< HEAD:src/_1_两数之和.java
public class _1_两数之和 {
=======
public class _1_两数之和_简单_哈希表 {
    //哈希表
>>>>>>> 7eddaf52c603911ad67def017835327ddfb51d34:src/_1_两数之和_简单_哈希表.java
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index !=  null) return new int[] {index , i};
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 */
public class _26_删除有序数组中的重复项 {
    /**
     * 快慢指针，快指针遍历，慢指针填充
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1, slow = 1; //开始在下标1的位置，因为第一个肯定是可以填充的
        while (fast <= nums.length - 1) {
            if (nums[fast] != nums[fast - 1]) { // 可以填充
                nums[slow] = nums[fast]; //将fast位置的值填充到slow位置
                slow++;
            }
            fast++;
        }
        return slow;
    }
}

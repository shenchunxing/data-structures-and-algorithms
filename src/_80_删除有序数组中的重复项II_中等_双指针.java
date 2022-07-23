/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class _80_删除有序数组中的重复项II_中等_双指针 {
    /**
     * 因为给定数组是有序的，所以相同元素必然连续
     * 双指针O(n) O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        //fast用于扫描，slow用于填充
        int slow = 2, fast = 2; //快慢指针
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) { //可以填充
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

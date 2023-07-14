package 排序指针;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
/*2023-7-14*/
public class _80_删除有序数组中的重复项II {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3}));
    }
    /**
     * 因为给定数组是有序的，所以相同元素必然连续
     * 双指针O(n) O(1)
     */
    static public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        //fast用于扫描，slow用于填充
        /*因为数组前2个元素即使相同也不需要被删除，因此直接从下标2开始扫描*/
        int slow = 2, fast = 2;
        while (fast < n) {
            /*说明没有联系的3个值是相等的，可以填充了。如果相等，第3个相等的值不能填充。*/
            if (nums[slow - 2] != nums[fast]) {
                /*填充*/
                nums[slow] = nums[fast];
                /*填充指针++*/
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

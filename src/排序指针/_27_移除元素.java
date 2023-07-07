package 排序指针;

/**
 * https://leetcode.cn/problems/remove-element/
 * 难度:简单
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 */
/*2023-7-7*/
public class _27_移除元素 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {3,2,2,3},2));
    }
    /*单指针*/
    static public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        /*idx指向可以填充的位置*/
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}

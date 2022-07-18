/**
 * https://leetcode.cn/problems/remove-element/
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 */
public class _27_移除元素_简单_单指针 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
<<<<<<< HEAD:src/_27_移除元素.java
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
=======
        int i = 0;//i是可以填充的位置
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
>>>>>>> 7eddaf52c603911ad67def017835327ddfb51d34:src/_27_移除元素_简单_单指针.java
            }
        }
        return idx;
    }
}

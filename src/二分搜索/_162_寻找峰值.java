package 二分搜索;

/**
 * https://leetcode.cn/problems/find-peak-element/
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题
 */
/*2023-7-6*/
public class _162_寻找峰值 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,3,1}));
    }

    static public int findPeakElement(int[] nums) {
        int l = 0 ,r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            /*为什么这里可以直接使用二分搜索，因为这个条件nums[i] != nums[i + 1]，所以如果nums[mid] > nums[mid + 1]，则最大值肯定在左半区*/
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}

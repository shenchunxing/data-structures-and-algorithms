package 二分搜索;

/**
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 * 难度：中等
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 */
/*2023-7-11 还需理解*/
public class _540_有序数组中的单一元素 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[] {1,1,2,2,3,3,4,8,8}));
    }
    /**
     * 必须满足O(log n) 时间复杂度
     * 思路：由于只出现一次的元素所在下标x, x的左边有偶数个元素，因此下标x 一定是偶数(因为下标从0开始)，可以在偶数下标范围内二分查找
     */
    static public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //如果mid是偶数，比较mid和mid + 1
            //如果mid是奇数，比较mid和mid - 1
            int value = mid % 2 == 0 ? nums[mid + 1] : nums[mid - 1];
            if (nums[mid] == value) { //nums[mid ^ 1]
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}

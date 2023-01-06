package 二分搜索;

/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class 剑指Offer53_I在排序数组中查找数字I {
    //O(logN) O(1)
    public int search(int[] nums, int target) {
        //确定左边界：第一个大于等于target的下标
        int leftIndex = binarySearch(nums,target,true);
        //确定右边界：第一个大于target的下标 -1
        int rightIndex = binarySearch(nums,target,false) - 1;
        //target可能不存在数组中，需要校验
        if (leftIndex <= rightIndex &&
                rightIndex < nums.length &&
                nums[leftIndex] == target &&
                nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    private int binarySearch(int[] nums , int target , boolean lower) {
        int left = 0, right = nums.length - 1,ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            //对于左边界，相等的时候，也需要继续逼近，直到找到第一个target的下标
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else  {
                left = mid + 1;
            }
        }
        return ans;
    }
}

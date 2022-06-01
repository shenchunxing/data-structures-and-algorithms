/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 */
public class _81_搜索旋转排序数组II {
    /**
     * 二分搜索：对于数组中有重复元素的情况，二分查找时可能会有a[l] = a[mid] = a[r],此时无法判断区间[l,mid]、[mid,r]哪个是有序的
     * 我们只能将当前二分区间的左边界加一，右边界减一，然后在新区间上继续二分查找。
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return target == nums[0];
        int l = 0 , r = n - 1;
        while (l <= r) {  //[2,5,6,0,0,1,2] target = 5
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true; //匹配
            //无法确定哪个区间是有序的，继续逼近
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) { //说明左半区是有序的
                if (target >= nums[l] && target <= nums[mid]) {//target就在左半区
                    r = mid - 1;
                } else { //target在右半区
                    l = mid + 1;
                }
            } else {   //说明右半区是有序的
                if (nums[mid] < target && target <= nums[n - 1]) { //target就在右半区
                    l = mid + 1;
                } else { //target在左半区
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
